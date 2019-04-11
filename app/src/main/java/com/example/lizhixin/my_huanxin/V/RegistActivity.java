package com.example.lizhixin.my_huanxin.V;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lizhixin.my_huanxin.M.User;
import com.example.lizhixin.my_huanxin.P.RegistPresenter;
import com.example.lizhixin.my_huanxin.P.RegistPrsesenterImpl;
import com.example.lizhixin.my_huanxin.R;
import com.example.lizhixin.my_huanxin.common.BaseActivity;
import com.example.lizhixin.my_huanxin.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity implements RegistView, TextView.OnEditorActionListener {

    @BindView(R.id.regist_user)
    EditText regist_user;
    @BindView(R.id.regist_pwd)
    EditText regist_pwd;
    @BindView(R.id.regist_btn)
    Button regist_btn;

    private RegistPresenter mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        regist_pwd.setOnEditorActionListener(this);
        mpresenter = new RegistPrsesenterImpl(this);
    }

    @OnClick(R.id.regist_btn)
    public void onViewClicked() {
          regist();
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_GO){
            regist();
        }
        return false;
    }

    private void regist() {
        String username = regist_user.getText().toString().trim();
        String pwd = regist_pwd.getText().toString().trim();
        if (!StringUtils.cheakusername(username)){
            Log.e("zhu_username",username);
              showToast("用户名不和法");
        }else if (!StringUtils.cheakuserpwd(pwd)){
            Log.e("zhu_pwd",pwd);
            showToast("密码不合法");
        }
        mpresenter.regist(username,pwd);
    }

    @Override
    public void showProgressDialog(String msg) {
        showDialog(msg,false);
    }

    @Override
    public void hideProgressDialog() {
        hideDialog();
    }

    @Override
    public void afterReist(User user, boolean flag,String msg) {
            if (flag){
               saveUser(user);
               startActivity(LoginActivity.class,flag);
            }else {
             //
                 showToast("注册失败！"+msg);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter = null;
    }
}
