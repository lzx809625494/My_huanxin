package com.example.lizhixin.my_huanxin.utils;

public class StringUtils {
    public static boolean cheakusername(String username){
        if (username == null){
            return false;
        }else{
            return username.matches("^[a-zA-Z]\\w{2,19}$");
        }
    }
    public static boolean cheakuserpwd(String userpwd){
        if (userpwd == null){
            return false;
        }else{
            return userpwd.matches("^[0-9]{3,20}$");
        }
    }
}
