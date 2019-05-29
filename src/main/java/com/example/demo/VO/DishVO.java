package com.example.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DishVO {

    @JsonProperty("id")
    private String dishId;

    @JsonProperty("name")
    private String dishName;

    @JsonProperty("price")
    private BigDecimal dishPrice;

    @JsonProperty("description")
    private String dishDescription;

    @JsonProperty("icon")
    private String dishIcon;
}
