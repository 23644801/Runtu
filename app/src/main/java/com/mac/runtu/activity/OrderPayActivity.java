package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mac.runtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderPayActivity extends AppCompatActivity {

    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.consignee_Tv)
    TextView consigneeTv;
    @BindView(R.id.phone_num_Tv)
    TextView phoneNumTv;
    @BindView(R.id.address_Tv)
    TextView addressTv;
    @BindView(R.id.change_Tv)
    TextView changeTv;
    @BindView(R.id.order_product_Iv)
    ImageView orderProductIv;
    @BindView(R.id.order_product_name_Tv)
    TextView orderProductNameTv;
    @BindView(R.id.totle_price_Tv)
    TextView totlePriceTv;
    @BindView(R.id.amountStr_Tv)
    TextView amountStrTv;
    @BindView(R.id.sub_Bt)
    Button subBt;
    @BindView(R.id.amount_Tv)
    TextView amountTv;
    @BindView(R.id.add_Bt)
    Button addBt;
    @BindView(R.id.amount_Iv)
    TextView amountIv;
    @BindView(R.id.total_commodity_price_Tv)
    TextView totalCommodityPriceTv;
    @BindView(R.id.distribution_mode_Tv)
    TextView distributionModeTv;
    @BindView(R.id.postage_Tv)
    TextView postageTv;
    @BindView(R.id.total_price_Tv)
    TextView totalPriceTv;
    @BindView(R.id.zhifubao_pay_Bt)
    Button zhifubaoPayBt;
    @BindView(R.id.weixin_pay_Bt)
    Button weixinPayBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.change_Tv, R.id.sub_Bt, R.id.add_Bt, R.id.zhifubao_pay_Bt, R.id.weixin_pay_Bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.change_Tv:
                startActivity(new Intent(OrderPayActivity.this, ManageReceiptAddressActivity.class));
                break;
            case R.id.sub_Bt:
                break;
            case R.id.add_Bt:
                break;
            case R.id.zhifubao_pay_Bt:
                Toast.makeText(OrderPayActivity.this, "支付宝支付", Toast.LENGTH_SHORT).show();
                break;
            case R.id.weixin_pay_Bt:
                Toast.makeText(OrderPayActivity.this, "微信支付", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
