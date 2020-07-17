package com.lss.st.util;

import sun.misc.BASE64Encoder;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenProccessor implements Serializable {
    private TokenProccessor(){

    }
    private static final TokenProccessor instance= new TokenProccessor();

    public static TokenProccessor getInstance(){
        return instance;
    }
    public String makeToken(){
        String token=(System.currentTimeMillis()+new Random().nextInt(9999999)+"");
        try{
            MessageDigest md = MessageDigest.getInstance("md5");
            //字符串转二进制 再加密
            byte md5[] = md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
