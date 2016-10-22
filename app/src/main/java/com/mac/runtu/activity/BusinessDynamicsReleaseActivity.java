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

public class BusinessDynamicsReleaseActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.merchants_Iv)
    ImageView merchantsIv;
    @BindView(R.id.household_Iv)
    ImageView householdIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_dynamics_release);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.merchants_Iv, R.id.household_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.merchants_Iv:
                startActivity(new Intent(BusinessDynamicsReleaseActivity.this,BusinessDynamicsMerchantsReleaseActivity.class));
                break;
            case R.id.household_Iv:
                startActivity(new Intent(BusinessDynamicsReleaseActivity.this,BusinessDynamicsHouseHoldRelease1Activity.class));
                break;
        }
    }
}
