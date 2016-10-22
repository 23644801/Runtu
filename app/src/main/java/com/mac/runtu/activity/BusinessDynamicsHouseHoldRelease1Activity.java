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

public class BusinessDynamicsHouseHoldRelease1Activity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.next_Iv)
    ImageView nextIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_dynamics_household_release1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.next_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.next_Iv:
                startActivity(new Intent(BusinessDynamicsHouseHoldRelease1Activity.this, BusinessDynamicsHouseHoldRelease2Activity
                        .class));
                break;
        }
    }
}
