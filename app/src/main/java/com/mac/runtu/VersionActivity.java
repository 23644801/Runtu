package com.mac.runtu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VersionActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_settings_version);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_Iv)
    public void onClick() {
        finish();
    }
}
