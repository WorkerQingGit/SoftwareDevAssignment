package com.example.demo.repository;

import com.example.demo.entity.order.dao.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByUserOpenid(String buyerOpenid, Pageable pageable);

    Page<OrderMaster> findByDeliverStatusAndUserOpenid(Integer deliverStatus,String userId,Pageable pageable);

    Page<OrderMaster> findByOrderStatusAndUserOpenid(Integer orderStatus,String userId,Pageable pageable);
}
