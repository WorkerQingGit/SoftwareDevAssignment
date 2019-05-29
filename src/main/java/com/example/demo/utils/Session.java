package com.example.demo.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Session {
    public static Map<String,String> session;
    public static Integer key;
    public static String addUser(String openid){
        if(session==null){
            session=new HashMap<String,String>();
        }
        String secret = encoder(openid);
        if(session.get(secret)==null)
        session.put(secret,openid);
        return secret;
    }
    public static String encoder(String openid){
        String secret = openid;//todo:加密
        return secret;
    }
    public static String decoder(String secret){
        String openid = session.get(secret);
        return openid;
    }
}
