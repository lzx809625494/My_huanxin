package com.example.lizhixin.my_huanxin.P;

import android.content.Context;

import com.example.lizhixin.my_huanxin.V.SqlashView;
import com.hyphenate.chat.EMClient;

public class SqlashPeesenterImpl  implements SqlashPresenter,SqlashView {

    SqlashView sqlashView;
    public SqlashPeesenterImpl(SqlashView sqlashView){
             this.sqlashView = sqlashView;
    }
    @Override
    public void isLogined() {
        if (EMClient.getInstance().isConnected() &&  EMClient.getInstance().isLoggedInBefore()){
              sqlashView.checkLogined(true);
        }else {
            sqlashView.checkLogined(false);
        }
    }

    @Override
    public void checkLogined(boolean isLogined) {

    }
}
