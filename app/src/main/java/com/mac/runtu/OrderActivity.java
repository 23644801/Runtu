package com.mac.runtu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mac.runtu.entity.Address;
import com.mac.runtu.entity.Order;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class OrderActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.search_Tv)
    EditText searchTv;
    @BindView(R.id.order_all_Tv)
    TextView orderAllTv;
    @BindView(R.id.pending_payment_order_Tv)
    TextView pendingPaymentOrderTv;
    @BindView(R.id.receipt_of_goods_order_Tv)
    TextView receiptOfGoodsOrderTv;
    @BindView(R.id.completed_order_Tv)
    TextView completedOrderTv;
    @BindView(R.id.order_ptr_frame)
    PtrFrameLayout orderPtrFrame;
    @BindView(R.id.order_Lv)
    ListView orderLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        orderPtrFrame.setPullToRefresh(true);
        orderPtrFrame.setKeepHeaderWhenRefresh(true);
        initData(Order.State.all);
    }

    void initData(Order.State state) {
        List<Order> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Order order = new Order();
            Address address = new Address();
            address.setCity("西安市");
            address.setCity("高新区");
            order.setAddress(address);
            order.setName("农家柿子饼白霜赛陕西富平柿子干霜降吊柿");
            order.setPrice(Math.round(30));
            order.setState(state);
            datas.add(order);
        }
        int resId = R.layout.order_item_layout;
        if (state == Order.State.pending_payment) {
            resId = R.layout.pending_payment_order_item_layout;
        }
        orderLv.setAdapter(new CommonAdapter<Order>(OrderActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, Order item, int position) {
                viewHolder.setText(R.id.order_product_name_Tv, item.getName());
                if (item.getState() == Order.State.receipt_of_goods) {
                    viewHolder.setText(R.id.state_Tv, "代收货");
                }

                if(item.getState() == Order.State.pending_payment){
                    viewHolder.setOnClickListener(R.id.order_pay_Iv, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(OrderActivity.this,OrderPayActivity.class));
                        }
                    });
                }
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
