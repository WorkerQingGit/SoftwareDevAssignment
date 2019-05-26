package com.example.demo.VO;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CanteenVO {

    @JsonProperty("name")
    private String canteenName;

    @JsonProperty("Id")
    private Integer canteenId;

    @JsonProperty("food")
    private List<DishVO> dishList;

    public CanteenVO(String canteenName, Integer canteenId, List<DishVO> dishList) {
        this.canteenName = canteenName;
        this.canteenId = canteenId;
        this.dishList = dishList;
    }

    public CanteenVO() {
    }
}
