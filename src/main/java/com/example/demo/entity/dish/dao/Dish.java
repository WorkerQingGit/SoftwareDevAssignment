package com.example.demo.entity.dish.dao;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Proxy(lazy = false)
public class Dish {

    @Id
    private String dishId;

    private String canteenId;

    private String sortId;

    private String dishName;

    private String dishDescription;

    private String dishIcon;

    private BigDecimal dishPrice;

    private Integer dishStatus;


}
