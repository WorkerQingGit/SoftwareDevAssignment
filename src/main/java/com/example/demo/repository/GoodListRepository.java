package com.example.demo.repository;

import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.entity.sort.dao.GoodList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodListRepository extends JpaRepository<GoodList,String> {

}
