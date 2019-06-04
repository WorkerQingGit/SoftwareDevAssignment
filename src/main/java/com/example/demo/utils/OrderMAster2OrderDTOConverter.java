package com.example.demo.utils;

import com.example.demo.entity.order.dao.OrderMaster;
import com.example.demo.entity.order.dto.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMAster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;


    }

    public static List<OrderDTO> convert(Page<OrderMaster> orderMasterDAOPage){
        return orderMasterDAOPage.stream().map(e->
                convert(e)).collect(Collectors.toList());
    }

}
