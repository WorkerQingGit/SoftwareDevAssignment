package com.example.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultVO<T> {

    //错误码
    @JsonProperty("name")
    private Integer code;

    //提示内容
    @JsonProperty("type")
    private String msg;

    //具体内容
    @JsonProperty("foods")
    private T data;

}
