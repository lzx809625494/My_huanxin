package com.example.lizhixin.my_huanxin.V;

import com.example.lizhixin.my_huanxin.M.User;

public interface LoginView extends BaseView{
    void afterLogin(User user,boolean isSuccess,String msg);
}
