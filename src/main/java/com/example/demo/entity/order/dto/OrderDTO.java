package com.example.demo.entity.order.dto;

import com.example.demo.entity.order.dao.OrderDetail;
import com.example.demo.enums.DeliverStatusEnums;
import com.example.demo.enums.OrderStatusEnums;
import com.example.demo.enums.PayStatusEnums;
import com.example.demo.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    //    order_id VARCHAR (32) NOT NULL,
    private String orderId;

    //    username VARCHAR (32) NOT NULL COMMENT '买家名字',
    private String username;

    //    user_phone VARCHAR (32) NOT NULL COMMENT '买家电话',
    private String userPhone;

    //    user_address VARCHAR (128) NOT NULL COMMENT '买家地址',
    private String userAddress;

    //    user_openid VARCHAR (64) NOT NULL COMMENT '买家微信openID',
    private String userOpenid;

    //    order_amount DECIMAL (8, 2) NOT NULL COMMENT '订单总金额',
    private BigDecimal orderAmount;

    //    order_status TINYINT (3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认为0',
    private int orderStatus;

    //    pay_status TINYINT (3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0是未支付',
    private int payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


    //运送状态，初始为未在运送
    private int deliverStatus = DeliverStatusEnums.DELIVER_NOT_ON_ROAD.getCode();

    //接单人，初始为空
    private String pickmanOpenid = null;

    private List<OrderDetail> orderDetailList;
}
