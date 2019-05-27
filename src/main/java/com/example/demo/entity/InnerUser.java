package com.example.demo.entity;
import lombok.Data;

import java.sql.Date;

@Data
public class InnerUser {
    String openid;
    String username;
    java.sql.Date userDate;
    String userPhone;
}
