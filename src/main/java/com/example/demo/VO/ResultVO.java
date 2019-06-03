package com.example.demo.VO;

import lombok.Data;

@Data
public class ResultVO<T> {

    //错误码
    private Integer code;

    //提示内容
    private String msg;

    //具体内容
    private T data;

}
