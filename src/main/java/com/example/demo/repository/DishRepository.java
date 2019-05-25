package com.example.demo.repository;

import com.example.demo.entity.dish.dao.DishDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<DishDAO,String> {

    List<DishDAO> findByDishStatus(Integer dishStatus);
}
