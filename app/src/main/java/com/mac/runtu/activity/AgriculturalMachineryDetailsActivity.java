package com.mac.runtu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgriculturalMachineryDetailsActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.phone_service_Iv)
    ImageView phoneServiceIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricultural_machinery_details);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.phone_service_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.phone_service_Iv:
                break;
        }
    }
}
