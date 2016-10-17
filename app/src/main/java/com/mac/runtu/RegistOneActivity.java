package com.mac.runtu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistOneActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.vc_Iv)
    ImageView vcIv;
    @BindView(R.id.next_Iv)
    ImageView nextIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.vc_Iv, R.id.next_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.vc_Iv:
                break;
            case R.id.next_Iv:
                startActivity(new Intent(this,RegistTwoActivity.class));
                break;
        }
    }
}
