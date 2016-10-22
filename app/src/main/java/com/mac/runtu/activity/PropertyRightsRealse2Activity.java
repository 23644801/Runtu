package com.mac.runtu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyRightsRealse2Activity extends AppCompatActivity {


    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.release_next_Iv)
    ImageView releaseNextIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_rights_release2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.release_next_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.release_next_Iv:
                finish();
                break;
        }
    }

}
