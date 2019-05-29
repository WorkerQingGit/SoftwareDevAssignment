package com.example.demo.service;

import com.example.demo.entity.order.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String userId, Pageable pageable);

    //查询未接单
    Page<OrderDTO> findNotDeliver(String userId,Pageable pageable);

    //查询正在派送总
    Page<OrderDTO> findDelivering(String userId,Pageable pageable);

    //查询已完成订单
    Page<OrderDTO> findFinished(String userId,Pageable pageable);


    //修改状态
    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //接单
    OrderDTO pick(OrderDTO orderDTO,String pickmanOpenId);

}
