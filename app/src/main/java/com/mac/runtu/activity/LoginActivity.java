package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username_Et)
    EditText usernameEt;
    @BindView(R.id.username_line)
    View usernameLine;
    @BindView(R.id.password_Et)
    EditText passwordEt;
    @BindView(R.id.password_line)
    View passwordLine;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.forgot_pwd_Tv)
    TextView forgotPwdTv;
    @BindView(R.id.login_Iv)
    ImageView loginIv;
    @BindView(R.id.reg_Iv)
    ImageView regIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_Iv, R.id.reg_Iv,R.id.forgot_pwd_Tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_Iv:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.reg_Iv:
                startActivity(new Intent(this,RegistOneActivity.class));
                break;
            case R.id.forgot_pwd_Tv:
                startActivity(new Intent(this,ForgetOnePwdActivity.class));
                break;
        }
    }
}
