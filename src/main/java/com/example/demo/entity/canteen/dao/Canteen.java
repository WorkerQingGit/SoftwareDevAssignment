package com.example.demo.entity.canteen.dao;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Canteen {

    @Id
    private Integer canteenId;

    private String canteenName;

    public Canteen(Integer canteenId, String canteenName) {
        this.canteenId = canteenId;
        this.canteenName = canteenName;
    }

    public Canteen() {
    }
}
