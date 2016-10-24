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

public class LogisticsInformationDetailsActivity extends AppCompatActivity {


    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.title_Tv)
    TextView titleTv;
    @BindView(R.id.time_Tv)
    TextView timeTv;
    @BindView(R.id.browse_Tv)
    TextView browseTv;
    @BindView(R.id.content_Tv)
    TextView contentTv;
    @BindView(R.id.crp_Lv)
    ListView crpLv;
    @BindView(R.id.shipment_Tv)
    TextView shipmentTv;
    @BindView(R.id.phone_service_Iv)
    ImageView phoneServiceIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_information_details);
        ButterKnife.bind(this);
        initData();
    }


    void initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        View header = getLayoutInflater().inflate(R.layout.logistcs_information_shipment_list_header_layout, null);
        crpLv.addHeaderView(header);
        int resId = R.layout.logistcs_information_shipment_list_item_layout;
        crpLv.setAdapter(new CommonAdapter<String>(LogisticsInformationDetailsActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
            }
        });
    }

    @OnClick({R.id.back_Iv, R.id.phone_service_Iv, R.id.shipment_Tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.phone_service_Iv:
                break;
            case R.id.shipment_Tv:
                startActivity(new Intent(LogisticsInformationDetailsActivity.this, LogisticsInformationIncidentallyReleaseActivity.class));
                break;
        }
    }
}
