package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetOnePwdActivity extends AppCompatActivity {

    @BindView(R.id.vc_Iv)
    ImageView vcIv;
    @BindView(R.id.next_Iv)
    ImageView nextIv;
    @BindView(R.id.back_Iv)
    ImageView backIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.vc_Iv, R.id.next_Iv,R.id.back_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vc_Iv:
                break;
            case R.id.next_Iv:
                startActivity(new Intent(this, ForgetTwoPwdActivity.class));
                break;
            case R.id.back_Iv:
                finish();
                break;
        }
    }
}
