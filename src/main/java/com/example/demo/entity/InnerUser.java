package com.example.demo.entity;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class InnerUser{
    String openid;
    String username;
    java.sql.Date userDate;
    String userDateString;
    String userPhone;
    String address;
}
