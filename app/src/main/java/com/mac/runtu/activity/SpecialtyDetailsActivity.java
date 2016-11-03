package com.mac.runtu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SpecialtyDetailsActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.buy_Iv)
    ImageView buyIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty_details);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.buy_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.buy_Iv:
                break;
        }
    }
}
