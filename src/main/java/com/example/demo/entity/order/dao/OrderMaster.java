package com.example.demo.entity.order.dao;

import com.example.demo.enums.DeliverStatusEnums;
import com.example.demo.enums.OrderStatusEnums;
import com.example.demo.enums.PayStatusEnums;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@Proxy(lazy = false)
public class OrderMaster {


//    order_id VARCHAR (32) NOT NULL,
    @Id
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
    private int orderStatus = OrderStatusEnums.ORDER_NEW.getCode();

//    pay_status TINYINT (3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0是未支付',
    private int payStatus = PayStatusEnums.PAY_NOT_PAY.getCode();

    //运送状态，初始为未在运送
    private int deliverStatus = DeliverStatusEnums.DELIVER_NOT_ON_ROAD.getCode();

    //接单人，初始为空
    private String pickmanOpenid;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
