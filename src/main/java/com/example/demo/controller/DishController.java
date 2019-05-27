package com.example.demo.controller;


import com.example.demo.VO.CanteenVO;
import com.example.demo.VO.DishVO;
import com.example.demo.VO.ResultVO;
import com.example.demo.entity.canteen.dao.Canteen;
import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.service.CanteenService;
import com.example.demo.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//用户查询功能
@RestController
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private CanteenService canteenService;

    @GetMapping("/getAllCanteen")
    public ResultVO getAllCanteen(){

        List<Canteen> canteenList = canteenService.findAll();

        if(canteenList == null)return new ResultVO(-1,"ERROR",null);

        ResultVO resultVO = new ResultVO(0,"餐厅列表",canteenList);

        return resultVO;
    }

    //获取某个餐厅信息
    @GetMapping("/getCanteen")
    public ResultVO getCanteen(Integer canteenId){

        Canteen canteen = canteenService.findOne(canteenId);

        if(canteen == null) return new ResultVO(-1,"ERROR",null);

        ResultVO resultVO = new ResultVO(1,"餐厅详情",canteen);

        return resultVO;
    }

    //获取某个食堂下的所有餐品信息
    @GetMapping("/getDishCanteen")
    public ResultVO getDishByCanteen(Integer canteenId){

        Canteen canteen = canteenService.findOne(canteenId);

        List<Dish> dishList = dishService.findUpAll();
        if(dishList.size()==0)return new ResultVO(-2,"NULL",null);

        List<DishVO> result = new ArrayList<>();
        for(Dish dish:dishList){
            if(dish.getCanteenId() == canteenId){
                DishVO dishVO = new DishVO();
                BeanUtils.copyProperties(dish,dishVO);
                result.add(dishVO);
            }
        }

        CanteenVO canteenVO = new CanteenVO(canteen.getCanteenName(),canteen.getCanteenId(), result);

        return new ResultVO(2,"餐厅菜品详情",canteenVO);

    }

    //获取特定餐品信息
    @GetMapping("/getDish")
    public ResultVO getDish(Integer dishId){

        Dish dish = dishService.findOne(dishId);

        ResultVO resultVO = new ResultVO(3,"指定餐品详情",dish);

        return resultVO;
    }
}