package com.example.demo.controller;


import com.example.demo.VO.CanteenVO;
import com.example.demo.VO.DishVO;
import com.example.demo.VO.ResultVO;
import com.example.demo.entity.canteen.dao.Canteen;
import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.service.CanteenService;
import com.example.demo.service.DishService;
import com.example.demo.utils.ResultVOUtil;
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

    @RequestMapping("/getAllCanteen")
    public ResultVO getAllCanteen(){

        List<Canteen> canteenList = canteenService.findAll();

        if(canteenList == null)return ResultVOUtil.error(-1,"failed");

        return ResultVOUtil.success(canteenList);
    }

    //获取某个餐厅信息
    @RequestMapping("/getCanteen")
    public ResultVO getCanteen(String canteenId){

        Canteen canteen = canteenService.findOne(canteenId);

        CanteenVO canteenVO = new CanteenVO();
        BeanUtils.copyProperties(canteen,canteenVO);

        if(canteen == null) return ResultVOUtil.error(-1,"failed");

        return ResultVOUtil.success(canteenVO);
    }

    //获取某个食堂下的所有餐品信息
    @RequestMapping("/getDishCanteen")
    public ResultVO getDishByCanteen(String canteenId){

        Canteen canteen = canteenService.findOne(canteenId);

        List<Dish> dishList = dishService.findUpAll();
        if(dishList.size()==0)return ResultVOUtil.error(-1,"failed");

        List<DishVO> result = new ArrayList<>();
        for(Dish dish:dishList){
            if(dish.getCanteenId().equals(canteenId)){
                DishVO dishVO = new DishVO();
                BeanUtils.copyProperties(dish,dishVO);
                result.add(dishVO);
            }
        }

//        CanteenVO canteenVO = new CanteenVO(canteen.getCanteenName(),canteen.getCanteenId(), result);
        CanteenVO canteenVO = new CanteenVO();
        canteenVO.setCanteenId(canteen.getCanteenId());
        canteenVO.setCanteenName(canteen.getCanteenName());
        canteenVO.setDishList(result);

        return ResultVOUtil.success(canteenVO);

    }

    //获取特定餐品信息
    @RequestMapping("/getDish")
    public ResultVO getDish(String dishId){

        Dish dish = dishService.findOne(dishId);

        DishVO dishVO = new DishVO();
        BeanUtils.copyProperties(dish,dishVO);

        return ResultVOUtil.success(dishVO);
    }
}
