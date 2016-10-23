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

public class ShoppingCartActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.all_choice_Iv)
    ImageView allChoiceIv;
    @BindView(R.id.totle_price_Tv)
    TextView totlePriceTv;
    @BindView(R.id.crp_Lv)
    ListView crpLv;
    @BindView(R.id.settlement_Iv)
    ImageView settlementIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ButterKnife.bind(this);
        initData();
    }

    void initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.shopping_cart_item_layout;
        crpLv.setAdapter(new CommonAdapter<String>(ShoppingCartActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {

            }
        });

    }

    @OnClick({R.id.back_Iv, R.id.all_choice_Iv, R.id.settlement_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                break;
            case R.id.all_choice_Iv:
                break;
            case R.id.settlement_Iv:
                startActivity(new Intent(ShoppingCartActivity.this, OrderPayActivity.class
                ));
                break;
        }
    }
}
