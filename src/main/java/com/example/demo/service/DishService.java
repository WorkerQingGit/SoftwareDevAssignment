package com.example.demo.service;

import com.example.demo.entity.dish.dao.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishService {

    Dish findOne(String dishId);

    //返回给前端的列表
    List<Dish> findUpAll();

    //返回分页
    Page<Dish> findAll(Pageable pageable);

    Dish save(Dish dish);

}
