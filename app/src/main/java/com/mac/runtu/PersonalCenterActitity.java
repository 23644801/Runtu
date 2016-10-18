package com.mac.runtu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalCenterActitity extends AppCompatActivity {

    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.manage_site_Iv)
    ImageView manageSiteIv;
    @BindView(R.id.order_details_Tr)
    TableRow orderDetailsTr;
    @BindView(R.id.personal_center_Tr)
    TableRow personalCenterTr;
    @BindView(R.id.my_release_Tr)
    TableRow myReleaseTr;
    @BindView(R.id.setting_Tr)
    TableRow settingTr;
    @BindView(R.id.service_Tr)
    TableRow serviceTr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.profile_image, R.id.manage_site_Iv, R.id.order_details_Tr, R.id.personal_center_Tr, R.id.my_release_Tr, R.id.setting_Tr, R.id.service_Tr})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_image:
                break;
            case R.id.manage_site_Iv:
                break;
            case R.id.order_details_Tr:
                startActivity(new Intent(PersonalCenterActitity.this, OrderActivity.class));
                break;
            case R.id.personal_center_Tr:
                startActivity(new Intent(PersonalCenterActitity.this, PersonalCenterSettingActivity.class));
                break;
            case R.id.my_release_Tr:
                break;
            case R.id.setting_Tr:
                break;
            case R.id.service_Tr:
                break;
        }
    }
}
