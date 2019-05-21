package com.example.demo.entity;

import lombok.Data;
@Data
public class User {
    String openid; //	string 	用户唯一标识
    String session_key; //	string 	会话密钥
    String unionid; 	//string 	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
    int errcode; 	//number 	错误码
    String errmsg; 	//string 	错误信息
}
