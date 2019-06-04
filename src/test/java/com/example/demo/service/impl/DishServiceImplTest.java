package com.example.demo.service.impl;

import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.enums.DishStatusEnums;
import com.example.demo.service.DishService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DishServiceImplTest {

    @Autowired
    private DishService dishService;

    @Test
    public void findOne() {

        Dish result = dishService.findOne("1");

        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() {

        List<Dish> dishList = dishService.findUpAll();

        Assert.assertNotEquals(dishList.size(),0);

    }

    @Test
    public void findAll() {

        PageRequest pageRequest = new PageRequest(0,2);

        Page<Dish> dishPage = dishService.findAll(pageRequest);

        Assert.assertNotEquals(dishPage.getTotalElements(),0);



    }

    @Test
    public void save() {


        Dish dish = new Dish();
        dish.setCanteenId("101");
        dish.setDishDescription("Delicious");
        dish.setDishIcon("http://xxxxxx");
        dish.setDishId("1");
        dish.setDishName("TestDish");
        dish.setSortId("1");
        dish.setDishPrice(new BigDecimal(10));
        dish.setDishStatus(DishStatusEnums.DISH_ON_SALE.getCode());

        Dish result = dishService.save(dish);

        Assert.assertNotNull(result);


    }
}