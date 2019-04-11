package com.example.lizhixin.my_huanxin.P;

import com.example.lizhixin.my_huanxin.M.User;
import com.example.lizhixin.my_huanxin.V.LoginView;
import com.example.lizhixin.my_huanxin.adapter.EMCallbackAdapter;
import com.example.lizhixin.my_huanxin.utils.ThreadUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public  class LoginPresenterImpl  implements LoginPresenter{

    private LoginView loginView;
    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
    }
    @Override
    public void login(final String username, final String pwd) {
        EMClient.getInstance().login(username, pwd, new EMCallbackAdapter() {
            @Override
            public void onSuccess() {
              getHidDialog(new User(username,pwd),true,"登录成功");
            }

            @Override
            public void onError(int i, String s) {
               getHidDialog(new User(username,pwd),false,s);
            }
        });
    }
    private void getHidDialog(final User user, final boolean isSuccess, final String msg){

        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loginView.afterLogin(user,isSuccess,msg);
                loginView.hideProgressDialog();
            }
        });
    }
}
