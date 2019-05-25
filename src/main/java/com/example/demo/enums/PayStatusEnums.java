package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnums {
    PAY_NOT_PAY(0,"未支付"),
    PAY_PAYED(1,"已支付"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
