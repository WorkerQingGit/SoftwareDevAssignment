package com.example.demo.entity.order.dao;

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
public class OrderDetail {

//    detail_id VARCHAR (32) NOT NULL,
    @Id
    private String detailId;

//    order_id VARCHAR (32) NOT NULL,
    private String orderId;

//    dish_id VARCHAR (32) NOT NULL,
    private String dishId;

//    dish_name VARCHAR (64) NOT NULL,
    private String dishName;

//    dish_price DECIMAL (8, 2) NOT NULL,
    private BigDecimal dishPrice;

//    dish_quantity INT NOT NULL,
    private Integer dishQuantity;

//    dish_icon VARCHAR (512) COMMENT '商品小图',
    private String dishIcon;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;
}
