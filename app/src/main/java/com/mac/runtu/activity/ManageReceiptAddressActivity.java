package com.mac.runtu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mac.runtu.R;
import com.mac.runtu.entity.Address;
import com.mac.runtu.entity.ReceiptAddress;
import com.mac.runtu.entity.ReceiptUser;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManageReceiptAddressActivity extends AppCompatActivity {

    @BindView(R.id.address_Lv)
    ListView addressLv;
    @BindView(R.id.add_address_Bt)
    Button addAddressBt;
    @BindView(R.id.back_Iv)
    ImageView backIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_address);
        ButterKnife.bind(this);
        initData();
    }

    void initData() {
        List<ReceiptAddress> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Address address = new Address();
            address.setProvince("陕西省");
            address.setCity("西安市");
            address.setArea("高新区");
            address.setOther("高新路31号凯创国际A座808室");
            ReceiptUser receiptUser = new ReceiptUser();
            receiptUser.setName("吴江");
            receiptUser.setPhone("15248124812");
            ReceiptAddress receiptAddress = new ReceiptAddress();
            receiptAddress.setAddress(address);
            receiptAddress.setReceiptUser(receiptUser);
            datas.add(receiptAddress);
        }

        addressLv.setAdapter(new CommonAdapter<ReceiptAddress>(ManageReceiptAddressActivity.this, R.layout.manage_address_item_layout, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, ReceiptAddress item, int position) {
                viewHolder.setText(R.id.consignee_Tv, item.getReceiptUser().getName());
                viewHolder.setText(R.id.phone_num_Tv, item.getReceiptUser().getPhone());
                viewHolder.setText(R.id.address_Tv, item.getAddress().toString());

                viewHolder.setOnClickListener(R.id.delete_Tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ManageReceiptAddressActivity.this, R.string.delete, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @OnClick({R.id.add_address_Bt, R.id.back_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_address_Bt:
                startActivity(new Intent(ManageReceiptAddressActivity.this, AddReceiptAddressActivity.class));
                break;
            case R.id.back_Iv:
                finish();
                break;
        }
    }

}
