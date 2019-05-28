package com.example.demo.entity.canteen.dao;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
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
