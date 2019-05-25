package com.example.demo.repository;

import com.example.demo.entity.Order.dao.OrderDetailDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailDAO,String> {

    List<OrderDetailDAO> findByOrderId(String OrderId);
}
