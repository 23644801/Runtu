package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.mac.runtu.R;
import com.mac.runtu.entity.Order;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAdoptActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.order_all_Tv)
    TextView orderAllTv;
    @BindView(R.id.pending_payment_order_Tv)
    TextView pendingPaymentOrderTv;
    @BindView(R.id.receipt_of_goods_order_Tv)
    TextView receiptOfGoodsOrderTv;
    @BindView(R.id.completed_order_Tv)
    TextView completedOrderTv;
    @BindView(R.id.order_Lv)
    ListView orderLv;

    Handler refreshHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MyAdoptActivity.this, "刷新完毕", Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    @BindView(R.id.swipeRefreshLayout)
    PullRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_adopt);
        ButterKnife.bind(this);
        initData(Order.State.all);
    }

    void initData(final Order.State state) {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.my_adopt_completed_order_item_layout;
        if (state == Order.State.pending_payment) {
            resId = R.layout.my_adopt_pending_payment_order_item_layout;
        } else if (state == Order.State.receipt_of_goods) {
            resId = R.layout.my_adopt_pending_receipt_order_item_layout;
        }

        orderLv.setAdapter(new CommonAdapter<String>(MyAdoptActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {

            }
        });

        orderLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (state == Order.State.pending_payment) {
                    startActivity(new Intent(MyAdoptActivity.this, OrderPayActivity.class));
                }
            }
        });

        swipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        swipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // start refresh
                Toast.makeText(MyAdoptActivity.this, "开始刷新", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.back_Iv, R.id.order_all_Tv, R.id.pending_payment_order_Tv, R.id.receipt_of_goods_order_Tv, R.id.completed_order_Tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.order_all_Tv:
                initData(Order.State.all);
                break;
            case R.id.pending_payment_order_Tv:
                initData(Order.State.pending_payment);
                break;
            case R.id.receipt_of_goods_order_Tv:
                initData(Order.State.receipt_of_goods);
                break;
            case R.id.completed_order_Tv:
                initData(Order.State.all);
                break;
        }
    }
}
