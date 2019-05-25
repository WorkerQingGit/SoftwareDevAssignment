package com.example.demo.service.impl;

import com.example.demo.entity.Order.dao.OrderDetailDAO;
import com.example.demo.entity.Order.dao.OrderMasterDAO;
import com.example.demo.entity.Order.dto.OrderDTO;
import com.example.demo.entity.dish.dao.DishDAO;
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
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.security.Key;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private DishService dishService;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //随机生成订单号
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);

        //查询商品
        for(OrderDetailDAO orderDetailDAO:orderDTO.getOrderDetailDAOList()){
            DishDAO dishDAO = dishService.findOne(orderDetailDAO.getDishId());
            if(dishDAO == null) return null;//之后补写异常类

            //计算订单总价
            orderAmount = dishDAO.getDishPrice().multiply
                    (new BigDecimal(orderDetailDAO.getDishQuantity()))
                    .add(orderAmount);

            //订单详情入库
            BeanUtils.copyProperties(dishDAO,orderDetailDAO);
            orderDetailDAO.setDetailId(KeyUtils.genUniqueKey());
            orderDetailDAO.setOrderId(orderId);
            orderDetailRepository.save(orderDetailDAO);
        }

        //OrderMaster写入数据库
        OrderMasterDAO orderMasterDAO = new OrderMasterDAO();
        BeanUtils.copyProperties(orderDTO,orderMasterDAO);
        orderMasterDAO.setOrderId(orderId);
        orderMasterDAO.setOrderStatus(OrderStatusEnums.ORDER_NEW.getCode());
        orderMasterDAO.setPayStatus(PayStatusEnums.PAY_NOT_PAY.getCode());

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMasterDAO orderMasterDAO = orderMasterRepository.getOne(orderId);
        if(orderId == null) return  null;//补写异常

        List<OrderDetailDAO> orderDetailDAOList = orderDetailRepository.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailDAOList))return null;//补写异常

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMasterDAO,orderDTO);
        orderDTO.setOrderDetailDAOList(orderDetailDAOList);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String userId, Pageable pageable) {
        Page<OrderMasterDAO> orderMasterDAOPage = orderMasterRepository.findByUserOpenid(userId,pageable);

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
