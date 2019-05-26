package com.example.demo.repository;

import com.example.demo.entity.dish.dao.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,String> {

    List<Dish> findByDishStatus(Integer dishStatus);
}
