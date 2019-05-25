package com.example.demo.entity.Order.dao;

import com.example.demo.enums.OrderStatusEnums;
import com.example.demo.enums.PayStatusEnums;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderMasterDAO {


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


}
