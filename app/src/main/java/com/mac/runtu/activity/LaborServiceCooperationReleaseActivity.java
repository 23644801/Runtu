package com.mac.runtu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaborServiceCooperationReleaseActivity extends AppCompatActivity {

    @BindView(R.id.lsc_release_type_Sp)
    Spinner lscReleaseTypeSp;
    @BindView(R.id.city_Sp)
    Spinner citySp;
    @BindView(R.id.area_Sp)
    Spinner areaSp;
    @BindView(R.id.town_Sp)
    Spinner townSp;
    @BindView(R.id.street_Sp)
    Spinner streetSp;
    @BindView(R.id.lsc_release_title_Et)
    EditText lscReleaseTitleEt;
    @BindView(R.id.month_Sp)
    Spinner monthSp;
    @BindView(R.id.day_Sp)
    Spinner daySp;
    @BindView(R.id.ma_Sp)
    Spinner maSp;
    @BindView(R.id.lsc_release_person_Et)
    EditText lscReleasePersonEt;
    @BindView(R.id.lsc_release_phone_Et)
    EditText lscReleasePhoneEt;
    @BindView(R.id.lsc_release_vc_Et)
    EditText lscReleaseVcEt;
    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.confirm_release_Iv)
    ImageView confirmReleaseIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor_service_cooperation_release);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.confirm_release_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.confirm_release_Iv:
                finish();
                break;
        }
    }
}
