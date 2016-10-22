package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mac.runtu.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaborServiceCooperationDetailsActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.release_Iv)
    ImageView releaseIv;
    @BindView(R.id.title_Tv)
    TextView titleTv;
    @BindView(R.id.content_Tv)
    TextView contentTv;
    @BindView(R.id.crp_Lv)
    ListView crpLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor_service_cooperation_details);
        ButterKnife.bind(this);
        initData();
    }


    void initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.labor_service_cooperation_list_item_layout;
        crpLv.setAdapter(new CommonAdapter<String>(LaborServiceCooperationDetailsActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
            }
        });
    }

    @OnClick({R.id.back_Iv, R.id.release_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.release_Iv:
                startActivity(new Intent(LaborServiceCooperationDetailsActivity.this, LaborServiceCooperationReleaseActivity.class));
                break;
        }
    }
}
