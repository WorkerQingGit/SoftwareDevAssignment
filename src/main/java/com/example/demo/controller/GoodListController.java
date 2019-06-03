package com.example.demo.controller;


import com.example.demo.VO.ResultVO;
import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.entity.sort.dao.GoodList;
import com.example.demo.service.impl.GoodListServiceImpl;
import com.example.demo.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodListController {

    @Autowired
    private GoodListServiceImpl service;

    @RequestMapping("/getAllGoodList")
    public ResultVO getAllGoodList(){
        List<GoodList> GoodList = service.findAll();
        return ResultVOUtil.success(GoodList);
    }

    @RequestMapping("getDishBySortId")
    public ResultVO getDishBySortId(String sortId){
        List<Dish> dishList = service.findDishByGoodList(sortId);
        return ResultVOUtil.success(dishList);
    }
}
