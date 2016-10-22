package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyRightsRealse1Activity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.province_Sp1)
    Spinner provinceSp1;
    @BindView(R.id.city_Sp1)
    Spinner citySp1;
    @BindView(R.id.area_Sp1)
    Spinner areaSp1;
    @BindView(R.id.village_Sp1)
    Spinner villageSp1;
    @BindView(R.id.year_release1)
    Spinner yearRelease1;
    @BindView(R.id.month_release1)
    Spinner monthRelease1;
    @BindView(R.id.day_release1)
    Spinner dayRelease1;
    @BindView(R.id.release_next_Iv)
    ImageView releaseNextIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_rights_release1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.release_next_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.release_next_Iv:
                startActivity(new Intent(PropertyRightsRealse1Activity.this,PropertyRightsRealse2Activity.class));
                break;
        }
    }
}
