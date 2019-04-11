package com.example.lizhixin.my_huanxin.common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lizhixin.my_huanxin.M.User;
import com.example.lizhixin.my_huanxin.utils.ToastUtils;


public class BaseActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler() ;
    private ProgressDialog dialog;
    private SharedPreferences preferences;
    private static final String username_key = "username";
    private static final String pwd_key = "pwdname";
    public void startActivity(Class clazz,boolean isFinish){
        startActivity(new Intent(this,clazz));
        if (isFinish){
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        preferences = getSharedPreferences("config",MODE_PRIVATE);
    }
    public void saveUser(User user){
        String username = preferences.getString(username_key,null);
        String pwdname = preferences.getString(pwd_key,null);
          preferences.edit()
                  .putString(username_key,user.getName()).putString(pwd_key,user.getpassword()).commit();
    }
    public User getUser(){
        String username = preferences.getString(username_key,null);
        String userpwd = preferences.getString(pwd_key,null);
        User user = new User(username,userpwd);
        return  user;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dialog.dismiss();
    }
     public void showDialog(String msg,boolean isCanceble){
     dialog.setCancelable(isCanceble);
     dialog.setMessage(msg);
     dialog.show();
    }
    public void hideDialog(){
        if (dialog.isShowing()){
             dialog.hide();
        }
    }

    public void showToast(String msg){
        ToastUtils.showToast(this,msg);
    }
}