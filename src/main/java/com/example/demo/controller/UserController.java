package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @RequestMapping("/login")
    public String Login(HttpServletRequest request,String code) {
        String session = request.getSession().getId();
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx2d79b0e37d694e20&secret=5b0b5f8e8299b8596d94b4a643cb04a1&js_code="+code+"&grant_type=authorization_code";
        String response = restTemplate.getForObject(url,String.class);
        ResponseEntity<User> userResponse = restTemplate.getForEntity(url,User.class);
        User user = userResponse.getBody();
        //检测openid是否存在
        //首次登录则向数据库中写入openid
        //生成session并返回
        return session;
    }
}
