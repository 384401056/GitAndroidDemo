package com.blueice.emchatdemo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etName.getText().toString();
                String pwd = etPwd.getText().toString();
                login(userName, pwd);
            }
        });

    }


    /**
     * 登录
     *
     * @param name
     * @param pwd
     */
    private void login(final String name, final String pwd) {
        EMClient.getInstance().login(name, pwd, new EMCallBack() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "登录成功！");
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(int i, String s) {
                Log.e(TAG, "登录失败！[Errorcode:]" + i + " s");
            }

            @Override
            public void onProgress(int i, String s) {
            }
        });
    }
}














