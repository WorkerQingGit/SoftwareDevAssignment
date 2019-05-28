package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnums {
    ORDER_NEW(0,"新创建"),
    ORDER_BE_PICKED(1,"已被接单"),
    ORDER_FINISHED(2,"已完成"),
    ORDER_CANCELED(3,"已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
