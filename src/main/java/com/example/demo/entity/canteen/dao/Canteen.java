package com.example.demo.entity.canteen.dao;


import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy = false)
public class Canteen {

    @Id
    private String canteenId;

    private String canteenName;

    public Canteen(String canteenId, String canteenName) {
        this.canteenId = canteenId;
        this.canteenName = canteenName;
    }

    public Canteen() {
    }
}
