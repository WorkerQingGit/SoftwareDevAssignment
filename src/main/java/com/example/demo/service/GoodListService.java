package com.example.demo.service;

import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.entity.sort.dao.GoodList;

import java.util.List;

public interface GoodListService {
    List<GoodList> findAll();

    List<Dish> findDishByGoodList(String sortId);
}
