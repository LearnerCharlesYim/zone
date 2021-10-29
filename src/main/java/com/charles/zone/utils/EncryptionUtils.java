package com.charles.zone.utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;


public class EncryptionUtils {

    public static String getMD5Password(String password,String salt){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }

    public static String getSalt(){
        return UUID.randomUUID().toString().toUpperCase();
    }
}
