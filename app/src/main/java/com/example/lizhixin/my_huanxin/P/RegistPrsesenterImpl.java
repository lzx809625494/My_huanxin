package com.example.lizhixin.my_huanxin.P;

import android.util.Log;

import com.example.lizhixin.my_huanxin.M.User;
import com.example.lizhixin.my_huanxin.V.RegistView;
import com.example.lizhixin.my_huanxin.utils.ThreadUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class RegistPrsesenterImpl implements RegistPresenter {
    private RegistView registView;
    public RegistPrsesenterImpl(RegistView registView){
        this.registView = registView;
    }
    @Override
    public void regist(final String username, final String pwd) {
        //显示进度条对话框
        registView.showProgressDialog("正在注册");
        final User user = new User();
        user.setName(username);
        user.setpassword(pwd);
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null){
                    ThreadUtils.runOnsubThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                EMClient.getInstance().createAccount(username,pwd);
                                ThreadUtils.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        registView.hideProgressDialog();
                                        registView.afterReist(user,true,null);
                                    }
                                });
                            } catch (final HyphenateException e1) {
                                e1.printStackTrace();
                                Log.e("zhu","注册失败");
                                user.delete(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if (e == null){
                                            Log.e("zhu1","删除成功！");
                                        }else{
                                            Log.e("zhu1","删除失败！");
                                        }
                                    }
                                });
                                ThreadUtils.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        registView.hideProgressDialog();
                                        registView.afterReist(user,false,e1.getMessage());
                                    }
                                });
                            }
                        }
                    });
                }else{
                    registView.hideProgressDialog();
                    registView.afterReist(user,false,e.getMessage());
                }
            }
        });
    }
}
