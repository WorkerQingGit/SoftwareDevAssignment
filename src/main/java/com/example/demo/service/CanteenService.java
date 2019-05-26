package com.example.demo.service;

import com.example.demo.entity.canteen.dao.Canteen;

import java.util.List;

public interface CanteenService {

    Canteen findOne(Integer canteenId);

    List<Canteen> findAll();

    List<Canteen> findByCanteenId(List<Integer> canteenIdList);

    Canteen save(Canteen canteen);
}
