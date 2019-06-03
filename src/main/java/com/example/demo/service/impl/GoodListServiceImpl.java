package com.example.demo.service.impl;

import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.entity.sort.dao.GoodList;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.GoodListRepository;
import com.example.demo.service.GoodListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodListServiceImpl implements GoodListService {

    @Autowired
    private GoodListRepository repository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<GoodList> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Dish> findDishByGoodList(String sortId) {

        List<Dish> dishList;
        dishList = dishRepository.findBySortId(sortId);

        return dishList;
    }
}
