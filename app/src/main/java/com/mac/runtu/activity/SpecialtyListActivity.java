package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.mac.runtu.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SpecialtyListActivity extends AppCompatActivity {
    Handler refreshHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(SpecialtyListActivity.this, "刷新完毕", Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.crp_Lv)
    ListView crpLv;
    @BindView(R.id.swipeRefreshLayout)
    PullRefreshLayout swipeRefreshLayout;
    @BindView(R.id.filter_Iv)
    ImageView filterIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    void initView() {
        swipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        swipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // start refresh
                Toast.makeText(SpecialtyListActivity.this, "开始刷新", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //获取数据代码填这里
                        refreshHandler.sendEmptyMessage(1);
                    }
                }, 3000);
            }
        });
    }


    void initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.specialty_item_layout;
        crpLv.setAdapter(new CommonAdapter<String>(SpecialtyListActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setOnClickListener(R.id.product_details_Bt, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SpecialtyListActivity.this, SpecialtyDetailsActivity.class));
                    }
                });
            }
        });

    }


    @OnClick({R.id.back_Iv, R.id.filter_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.filter_Iv:
                startActivity(new Intent(SpecialtyListActivity.this, SpecialtyFilterActivity.class));
                break;
            case R.id.back_Iv:
                finish();
                break;
        }
    }
}
