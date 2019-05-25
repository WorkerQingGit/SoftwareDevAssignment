package com.example.demo.service.impl;

import com.example.demo.entity.dish.dao.DishDAO;
import com.example.demo.repository.DishRepository;
import com.example.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DishServieImpl implements DishService {

    @Autowired
    private DishRepository repository;

    @Override
    public DishDAO findOne(String dishId) {
        return repository.getOne(dishId);
    }

    @Override
    public List<DishDAO> findUpAll() {
        return repository.findAll();
    }

    @Override
    public Page<DishDAO> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public DishDAO save(DishDAO dishDAO) {
        return repository.save(dishDAO);
    }
}
