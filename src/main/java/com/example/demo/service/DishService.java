package com.example.demo.service;

import com.example.demo.entity.dish.dao.DishDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishService {

    DishDAO findOne(String dishId);

    //返回给前端的列表
    List<DishDAO> findUpAll();

    //返回分页
    Page<DishDAO> findAll(Pageable pageable);

    DishDAO save(DishDAO dishDAO);

}
