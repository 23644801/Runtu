package com.mac.runtu.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mac.runtu.R;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.personal_center_Ll)
    LinearLayout personalCenterLl;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.ses_Iv)
    ImageView sesIv;
    @BindView(R.id.ef_Iv)
    ImageView efIv;
    @BindView(R.id.lsc_Iv)
    ImageView lscIv;
    @BindView(R.id.business_dynamics_LL)
    LinearLayout businessDynamicsLL;
    @BindView(R.id.circulation_of_property_rights_LL)
    LinearLayout circulationOfPropertyRightsLL;
    @BindView(R.id.rural_tourism_LL)
    LinearLayout ruralTourismLL;
    @BindView(R.id.logistics_distribution_LL)
    LinearLayout logisticsDistributionLL;
    @BindView(R.id.entrepreneurship_training_LL)
    LinearLayout entrepreneurshipTrainingLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBannerData();
    }

    void initBannerData() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(context).load(path.toString()).into(imageView);
            }
        });
        String[] urlStrings = getResources().getStringArray(R.array.urls);
        List<String> images = Arrays.asList(urlStrings);
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(Arrays.asList(titles));
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @OnClick(R.id.personal_center_Ll)
    public void onClick() {
        startActivity(new Intent(this, PersonalCenterActitity.class));
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        EasyPermissions.checkDeniedPermissionsNeverAskAgain(this,
                getString(R.string.denied_permission_msg),
                R.string.setting, R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.get_permission_fail_msg, Toast.LENGTH_SHORT).show();
                    }
                }, perms);
    }

    public static String[] requestPermissions = new String[]{
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.VIBRATE,
            Manifest.permission.FLASHLIGHT,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    public static final int appPermissionsCode = 369;

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (!EasyPermissions.hasPermissions(this, requestPermissions)) {
            EasyPermissions.requestPermissions(this, getString(R.string.get_permission_msg),
                    appPermissionsCode, requestPermissions);
        }
    }

    @OnClick({R.id.business_dynamics_LL, R.id.circulation_of_property_rights_LL, R.id.rural_tourism_LL, R.id.logistics_distribution_LL, R.id.entrepreneurship_training_LL})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.business_dynamics_LL:
                startActivity(new Intent(MainActivity.this, BusinessDynamicsActivity.class));
                break;
            case R.id.circulation_of_property_rights_LL:
                break;
            case R.id.rural_tourism_LL:
                break;
            case R.id.logistics_distribution_LL:
                break;
            case R.id.entrepreneurship_training_LL:
                break;
        }
    }
}