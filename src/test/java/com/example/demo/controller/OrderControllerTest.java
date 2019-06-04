package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderControllerTest {

    @Autowired
    private OrderController controller;

    @Test
    public void create() {
        String openId = "101";
        String[] dishid = {"1","2"};
        String[] dishnum = {"1","1"};

        controller.create(openId,dishid,dishnum);

    }
}