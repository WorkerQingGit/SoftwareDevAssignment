package com.example.demo.enums;


import lombok.Getter;

@Getter
public enum DeliverStatusEnums {
    DELIVER_NOT_ON_ROAD(0,"订单未在配送"),
    DELIVER_ON_ROAD(1,"订单在配送"),
    ;

    private Integer code;

    private String msg;

    DeliverStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
