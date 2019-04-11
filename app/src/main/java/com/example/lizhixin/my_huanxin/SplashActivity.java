package com.example.lizhixin.my_huanxin;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lizhixin.my_huanxin.P.SqlashPeesenterImpl;
import com.example.lizhixin.my_huanxin.V.LoginActivity;
import com.example.lizhixin.my_huanxin.V.LoginView;
import com.example.lizhixin.my_huanxin.V.SqlashView;
import com.example.lizhixin.my_huanxin.common.BaseActivity;
import com.example.lizhixin.my_huanxin.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SqlashView {
    @BindView(R.id.img)
    ImageView img;

//    private ImageView img;
    SqlashPeesenterImpl peesenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        //判断是否以登录
        peesenter = new SqlashPeesenterImpl(this);
        peesenter.isLogined();
    }


    @Override
    public void checkLogined(boolean isLogined) {
        if (isLogined){
            startActivity(MainActivity.class,true);
            finish();
        }else {
            ObjectAnimator animator = ObjectAnimator.ofFloat(img,"alpha",0,1).setDuration(2000);
            animator.start();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(LoginActivity.class,true);
                    finish();
                }
            },2000);
        }
    }
}
