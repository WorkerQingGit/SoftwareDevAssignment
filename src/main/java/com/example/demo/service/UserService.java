package com.example.demo.service;

import com.example.demo.entity.InnerUser;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.WxMappingJackson2HttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User login(String code){
        if(code!=null){
            code=code.trim();
        }
        System.out.println(code);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxabf83e0d1645986b&secret=059a3beb8a32580d0934113900cf4961&js_code="+code+"&grant_type=authorization_code";
        System.out.println(url);
        ResponseEntity<User> userResponse = restTemplate.getForEntity(url,User.class);
        User user = userResponse.getBody();
        System.out.println("openid"+user.getOpenid());
        System.out.println("errcode"+user.getErrcode());
        System.out.println("Errmsg"+user.getErrmsg());
        return user;
    }
    public boolean checkUser(String openid)throws RuntimeException {
        System.out.println(openid);
        Integer result = 0;
        result = userMapper.selectUser(openid);
        System.out.println("1.0");
        if (result != null) {
            return true;
        }
        System.out.println("1.1");
        Date date = new Date();
        int createResult = userMapper.createUser(openid, new java.sql.Date(date.getTime()));
        System.out.println("1.2");
        if(createResult==0){
            throw new RuntimeException("新建用户失败");
        }
        return true;
    }

    public InnerUser selectAimUser(String openid)throws  RuntimeException{
        InnerUser user = userMapper.selectAimUser(openid);
        return user;
    }
    public InnerUser updateUserInfo(InnerUser user){
        userMapper.updateUserInfo(user);
        InnerUser result = userMapper.selectAimUser(user.getOpenid());
        return result;
    }
}

