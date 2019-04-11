package com.example.lizhixin.my_huanxin.V;

import com.example.lizhixin.my_huanxin.M.User;

public interface RegistView  extends BaseView{
    void afterReist(User user, boolean flag,String msg);
}
