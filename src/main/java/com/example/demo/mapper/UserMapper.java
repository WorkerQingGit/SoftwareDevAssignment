package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT name \n" +
            "FROM canteen \n" +
            "WHERE id = 0;")
    String sqlTest();
}
