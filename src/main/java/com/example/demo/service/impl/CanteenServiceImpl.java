package com.example.demo.service.impl;


import com.example.demo.entity.canteen.dao.Canteen;
import com.example.demo.repository.CanteenRepository;
import com.example.demo.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService {

    @Autowired
    private CanteenRepository repository;

    @Override
    public Canteen findOne(String canteenId) {
        return repository.getOne(canteenId);
    }

    @Override
    public List<Canteen> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Canteen> findByCanteenId(List<String> canteenIdList) {
        return repository.findByCanteenId(canteenIdList);
    }

    @Override
    public Canteen save(Canteen canteen) {
        return repository.save(canteen);
    }
}
