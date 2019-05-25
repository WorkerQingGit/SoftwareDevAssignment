package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnums {
    ORDER_NEW(0,"新创建"),
    ORDER_FINISHED(1,"已完成"),
    ORDER_CANCELED(2,"已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
