package com.example.demo.service.impl;

import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.repository.DishRepository;
import com.example.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class DishServieImpl implements DishService {

    @Autowired
    private DishRepository repository;

    @Override
    public Dish findOne(Integer dishId) {
        return repository.getOne(dishId.toString());
    }

    @Override
    public List<Dish> findUpAll() {
        return repository.findAll();
    }

    @Override
    public Page<Dish> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }
}
