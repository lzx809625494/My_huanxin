package com.example.lizhixin.my_huanxin.V;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lizhixin.my_huanxin.M.User;
import com.example.lizhixin.my_huanxin.MainActivity;
import com.example.lizhixin.my_huanxin.P.LoginPresenter;
import com.example.lizhixin.my_huanxin.P.LoginPresenterImpl;
import com.example.lizhixin.my_huanxin.R;
import com.example.lizhixin.my_huanxin.common.BaseActivity;
import com.example.lizhixin.my_huanxin.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView, TextView.OnEditorActionListener {
    @BindView(R.id.login_user)
    EditText loginUser;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_new)
    TextView loginNew;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl(this);
        loginPwd.setOnEditorActionListener(this);
    }


    @OnClick({R.id.login_btn, R.id.login_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                login();

                break;
            case R.id.login_new:
                startActivity(RegistActivity.class,true);
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_GO){
            login();
           return true;
        }else{

        }
        return false;
    }

    private void login() {
        String username = loginUser.getText().toString().trim();

        String pwd = loginPwd.getText().toString().trim();
        if (!StringUtils.cheakusername(username)){
          showToast("用户名不合法");
          return;
        }else if(!StringUtils.cheakuserpwd(pwd)){
            showToast("用户名不合法");
            return;
        }

        //手动开启读写权限
        int i = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (i != PermissionChecker.PERMISSION_GRANTED){
            //没有被授权，请求用户给权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
             return;
        }else{
            presenter.login(username,pwd);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            if (permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)&grantResults[0] == PermissionChecker.PERMISSION_GRANTED){
                login();
            }else{
                showToast("您以拒绝开启权限！");
            }
        }
    }

    @Override
    public void afterLogin(User user, boolean isSuccess, String msg) {
         if (isSuccess){
             saveUser(user);
             startActivity(MainActivity.class,true);
         }else{
             showToast(msg);
         }
    }

    @Override
    public void showProgressDialog(String msg) {
        showDialog(msg,false);
    }

    @Override
    public void hideProgressDialog() {
      hideDialog();
    }
}
