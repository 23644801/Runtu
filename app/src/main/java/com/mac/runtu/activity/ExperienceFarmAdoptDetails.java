package com.mac.runtu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mac.runtu.R;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExperienceFarmAdoptDetails extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.base_introduce_Tv)
    TextView baseIntroduceTv;
    @BindView(R.id.add_cart_Tv)
    TextView addCartTv;
    @BindView(R.id.buy_Iv)
    ImageView buyIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_farm_adopt_details);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.buy_Iv,R.id.add_cart_Tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.buy_Iv:
                break;
            case R.id.add_cart_Tv:
                break;
        }
    }
}
