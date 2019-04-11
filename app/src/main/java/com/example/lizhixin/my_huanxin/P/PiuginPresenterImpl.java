package com.example.lizhixin.my_huanxin.P;

import com.example.lizhixin.my_huanxin.V.PiuginView;
import com.example.lizhixin.my_huanxin.adapter.EMCallbackAdapter;
import com.example.lizhixin.my_huanxin.utils.ThreadUtils;
import com.hyphenate.chat.EMClient;

public class PiuginPresenterImpl implements PiuginPresenter {
    private PiuginView mPiuginView;
    public PiuginPresenterImpl(PiuginView piuginView){
            this.mPiuginView = piuginView;
    }
    @Override
    public void logout() {
        EMClient.getInstance().logout(true,new EMCallbackAdapter(){
            @Override
            public void onSuccess() {
                super.onSuccess();
                gotoLogin(true,null);
            }

            @Override
            public void onError(int i, String s) {
                super.onError(i, s);
                gotoLogin(false,s);
            }
        });
    }
    private void gotoLogin(final boolean success, final String msg){
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPiuginView.afterLogout(success,msg);
            }
        });
    }
}
