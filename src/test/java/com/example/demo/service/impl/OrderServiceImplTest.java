package com.example.demo.service.impl;

import com.example.demo.entity.order.dao.OrderDetail;
import com.example.demo.entity.order.dao.OrderMaster;
import com.example.demo.entity.order.dto.OrderDTO;
import com.example.demo.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private final String OPENID="101";

    private final String ORDEID = "1559292304914994136";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserOpenid(OPENID);
        orderDTO.setUserAddress("xxxx");
        orderDTO.setUserPhone("110");
        orderDTO.setUsername("daddt");


        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setDishId("1");
        o1.setDishQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setDishId("2");
        o2.setDishQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {

        OrderDTO orderDTO = orderService.findOne(ORDEID);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {

        Page<OrderDTO> orderDTOPage;

        PageRequest pageRequest = new PageRequest(0,2);
        orderDTOPage = orderService.findList(OPENID,pageRequest);
        Assert.assertNotEquals(orderDTOPage.getTotalElements(),0);
    }

    @Test
    public void findNotDeliver() {

        Page<OrderDTO> orderDTOPage = orderService.findNotDeliver(OPENID,new PageRequest(0,2));
        Assert.assertNotEquals(orderDTOPage.getTotalElements(),0);
    }

    @Test
    public void findDelivering() {
    }

    @Test
    public void findFinished() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void paid() {
    }

    @Test
    public void pick() {
    }
}