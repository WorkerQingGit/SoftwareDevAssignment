package com.example.demo.utils;

import com.example.demo.entity.order.dao.OrderDetail;
import com.example.demo.entity.order.dto.OrderDTO;
import com.example.demo.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUsername(orderForm.getName());
        orderDTO.setUserPhone(orderForm.getPhone());
        orderDTO.setUserAddress(orderForm.getAddress());
        orderDTO.setUserOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDTO>>(){
                    }.getType());
        }catch(Exception e){
            throw e;
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;

    }
}
