package com.example.demo.controller;


import com.example.demo.VO.ResultVO;
import com.example.demo.service.CanteenService;
import com.example.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用户查询功能
@RestController
@RequestMapping("/buyer/dishes")
public class BuyerDishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private CanteenService canteenService;

    @GetMapping("/list")
    public ResultVO list(){
        return null;
    }
}
