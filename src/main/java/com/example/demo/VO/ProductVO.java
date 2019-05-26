package com.example.demo.VO;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    @JsonProperty("name")
    private String canteenName;

    @JsonProperty("Id")
    private Integer canteenId;

    @JsonProperty("food")
    private List<DishVO> dishList;
}
