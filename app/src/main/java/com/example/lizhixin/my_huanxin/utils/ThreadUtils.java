package com.example.lizhixin.my_huanxin.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadUtils  {
    private static Executor executor = Executors.newSingleThreadExecutor();
    private static Handler handler = new Handler(Looper.getMainLooper());
    public static void runOnsubThread(Runnable runnable){
          executor.execute(runnable);
    }
    public static void runOnUiThread(Runnable runnable){
         handler.post(runnable);
    }
}
