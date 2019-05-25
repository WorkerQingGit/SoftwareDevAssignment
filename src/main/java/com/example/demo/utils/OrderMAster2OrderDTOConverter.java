package com.example.demo.utils;

import com.example.demo.entity.Order.dao.OrderMasterDAO;
import com.example.demo.entity.Order.dto.OrderDTO;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderMAster2OrderDTOConverter {

    public static OrderDTO convert(OrderMasterDAO orderMasterDAO){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMasterDAO,orderDTO);
        return orderDTO;


    }

    public static List<OrderDTO> convert(Page<OrderMasterDAO> orderMasterDAOPage){
        return orderMasterDAOPage.stream().map(e->
                convert(e)).collect(Collectors.toList());
    }
}
