package com.example.demo.controller;

import com.example.demo.entity.InnerUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    public UserService userService;

    @PostMapping("/login")
    public String Login(HttpServletRequest request,String code) {
        String session = request.getSession().getId();
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx2d79b0e37d694e20&secret=5b0b5f8e8299b8596d94b4a643cb04a1&js_code="+code+"&grant_type=authorization_code";
        String response = restTemplate.getForObject(url,String.class);
        ResponseEntity<User> userResponse = restTemplate.getForEntity(url,User.class);
        User user = userResponse.getBody();
        userService.checkUser(user.getOpenid());
        session = Session.addUser(user.getOpenid());
        //检测openid是否存在
        //首次登录则向数据库中写入openid
        //生成session并返回
        return session;
    }

    @PostMapping("/getUserInfo")
    public InnerUser getUserInfo(HttpServletRequest request,String openid){
        String session = request.getSession().getId();
        if(Session.decoder(session)!=null){
            InnerUser user = userService.selectAimUser(openid);
            return user;
        }
        //todo: 会话管理
        return null;
    }
    @PostMapping("/resetData")
    public InnerUser resetData(HttpServletRequest request,InnerUser user){
        String session = request.getSession().getId();
        if(Session.decoder(session)!=null){

        }
        //todo: resetData
        return user;
    }
}
