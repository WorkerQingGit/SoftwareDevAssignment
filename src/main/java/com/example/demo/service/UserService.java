package com.example.demo.service;

import com.example.demo.entity.InnerUser;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean checkUser(String openid)throws RuntimeException {
        Integer result;
        result = userMapper.selectUser(openid);
        if (result == 1) {
            return true;
        }
        Date date = new Date();
        Integer createResult = userMapper.createUser(openid, new java.sql.Date(date.getTime()));
        if(createResult==0){
            throw new RuntimeException("新建用户失败");
        }
        return true;
    }

    public InnerUser selectAimUser(String openid)throws  RuntimeException{
        InnerUser user = userMapper.selectAimUser(openid);
        return user;
    }
}
