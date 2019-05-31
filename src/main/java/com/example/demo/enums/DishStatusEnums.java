package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum DishStatusEnums {
    DISH_ON_SALE(0,"上架中"),
    DISH_NOT_ON_SALE(1,"下架"),

    ;

    private Integer code;

    private String msg;

    DishStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
