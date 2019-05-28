package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.entity.order.dto.OrderDTO;
import com.example.demo.form.OrderForm;
import com.example.demo.service.OrderService;
import com.example.demo.utils.OrderForm2OrderDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping("/order")
    public ResultVO<Map<String ,String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return null;//补写错误信息
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            return null;//补写错误
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String ,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return new ResultVO(5,"创建订单",map);

    }

    //订单列表
    @RequestMapping("/showList")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            return null;//补写异常
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        return new ResultVO(6,"订单列表",orderDTOPage);
    }

    //查询单个订单
    @RequestMapping("/showList/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openId") String openid,
                                     @RequestParam("orderId") String orderId){
        //TODO 不安全做法
        OrderDTO orderDTO = orderService.findOne(orderId);
        return new ResultVO(7,"查询单个订单",orderDTO);
    }

    //取消订单
    @RequestMapping("/showList/detail/cancel")
    public ResultVO cancel(@RequestParam("openId") String openid,
                           @RequestParam("orderId") String orderId){

        //TODO 不安全
        OrderDTO orderDTO = orderService.findOne(orderId);

        orderService.cancel(orderDTO);
        return new ResultVO(8,"取消订单",orderDTO);
    }

    //接单
}
