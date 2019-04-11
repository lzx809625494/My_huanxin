package com.example.lizhixin.my_huanxin.M;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class User extends BmobObject {
     public  User(){

     }
    private String name;
    private String password;
    public User(String name,String password){
        setName(name);
        setpassword(password);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
}
