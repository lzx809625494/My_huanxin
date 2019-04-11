package com.example.lizhixin.my_huanxin.utils;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {
    public void  getHttpGet(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Eorrer", "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("sueess", "onResponse: " + response.body().string());
            }
        });
    }
    public void getHttpPost(String url,String username,String pwd){
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("username", username)
                .add("password",pwd)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Error", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("asd", response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    Log.d("asd", headers.name(i) + ":" + headers.value(i));
                }
                Log.d("asd", "onResponse: " + response.body().string());
            }
        });
    }
    public void Login(String uri,String name ,String psd){

        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(2000, TimeUnit.MINUTES)
                .readTimeout(2000, TimeUnit.MINUTES)
                .build();
        FormBody build2 = new FormBody.Builder()
                .add("username", name)
                .add("password", psd)
                .add("repassword", psd)
                .build();

        Request.Builder builder = new Request.Builder().url(uri).post(build2);


        Call call = build.newCall(builder.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("sdf",string);
            }
        });
    }
}
