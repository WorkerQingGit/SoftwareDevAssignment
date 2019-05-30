package com.example.demo.mapper;

import com.example.demo.entity.InnerUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Mapper
public interface UserMapper {
    @Select("SELECT 1\n" +
            "FROM user \n" +
            "WHERE user_openid = #{param1}\n" +
            "limit 1;")
    Integer selectUser(String openid);

    @Insert("INSERT INTO user \n" +
            "(user_openid,user_date) \n" +
            "VALUES (#{param1},#{param2});")
    Integer createUser(String openid , Date date);

    @Select("SELECT \n" +
            "user_openid AS openid, \n" +
            "username AS username, \n" +
            "user_date AS userDate, \n" +
            "user_phone AS userPhone, \n" +
            "user_address AS address " +
            "FROM user \n" +
            "WHERE user_openid=#{param1};")
    InnerUser selectAimUser(String openid);

    @Update("UPDATE user SET\n" +
            "username = #{username}, \n" +
            "user_phone = #{userPhone}, \n" +
            "user_address = #{address} \n" +
            "WHERE user_openid = #{openid}")
    Integer updateUserInfo(InnerUser user);
}
