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
        System.out.println(code);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx2d79b0e37d694e20&secret=5b0b5f8e8299b8596d94b4a643cb04a1&js_code="+code+"&grant_type=authorization_code";
        String response = restTemplate.getForObject(url,String.class);
        ResponseEntity<User> userResponse = restTemplate.getForEntity(url,User.class);
        User user = userResponse.getBody();
        return user;
    }
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

