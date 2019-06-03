package com.example.demo.entity.sort.dao;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class GoodList {

    @Id
    private String sortId;

    private String classifyName;

}
