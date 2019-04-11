package com.example.lizhixin.my_huanxin.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class ToastUtils {

    public static  ToastUtils utils;
    public static Toast toast;
    private static Handler handler = new Handler(Looper.getMainLooper());
    public static  void showToast(Context context,String msg){
        if (toast == null){
            toast = Toast.makeText(context.getApplicationContext(),msg,Toast.LENGTH_SHORT);
        }
        if (Looper.myLooper() == Looper.getMainLooper()){
            toast.show();
        }else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    toast.show();
                }
            });
        }
    }
    public static ToastUtils  getToastUtils(){
        if (utils == null){
            utils = new ToastUtils();
        }
        return utils;
    }

}
