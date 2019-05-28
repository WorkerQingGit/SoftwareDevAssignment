package com.example.demo.service.impl;

import com.example.demo.entity.order.dao.OrderDetail;
import com.example.demo.entity.order.dao.OrderMaster;
import com.example.demo.entity.order.dto.OrderDTO;
import com.example.demo.entity.dish.dao.Dish;
import com.example.demo.enums.OrderStatusEnums;
import com.example.demo.enums.PayStatusEnums;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderMasterRepository;
import com.example.demo.service.DishService;
import com.example.demo.service.OrderService;
import com.example.demo.utils.KeyUtils;
import com.example.demo.utils.OrderMAster2OrderDTOConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private DishService dishService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        /*
        //随机生成订单号
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);

        //查询商品
        for(OrderDetail orderDetail :orderDTO.getOrderDetailList()){
            Dish dish = dishService.findOne(orderDetail.getDishId());
            if(dish == null) return null;//之后补写异常类

            //计算订单总价
            orderAmount = dish.getDishPrice().multiply
                    (new BigDecimal(orderDetail.getDishQuantity()))
                    .add(orderAmount);

            //订单详情入库
            BeanUtils.copyProperties(dish, orderDetail);
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);
        }

        //OrderMaster写入数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderStatus(OrderStatusEnums.ORDER_NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.PAY_NOT_PAY.getCode());

        */
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster = orderMasterRepository.getOne(orderId);
        if(orderId == null) return  null;//补写异常

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailList))return null;//补写异常

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String userId, Pageable pageable) {
        Page<OrderMaster> orderMasterDAOPage = orderMasterRepository.findByUserOpenid(userId,pageable);

        List<OrderDTO> orderDTOList = OrderMAster2OrderDTOConverter.convert(orderMasterDAOPage);

        return new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterDAOPage.getTotalElements());

    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO cancle(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO pay(OrderDTO orderDTO) {
        return null;
    }
}
