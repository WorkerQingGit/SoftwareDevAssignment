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

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO() {
    }
}
