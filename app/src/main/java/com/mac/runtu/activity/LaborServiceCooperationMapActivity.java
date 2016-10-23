package com.mac.runtu.activity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.mac.runtu.R;
import com.mac.runtu.entity.LaborServiceInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaborServiceCooperationMapActivity extends AppCompatActivity {


    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.my_release_Iv)
    ImageView myReleaseIv;
    @BindView(R.id.confirm_Iv)
    ImageView conformIv;
    @BindView(R.id.bmapView)
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor_service_cooperation_map);
        ButterKnife.bind(this);
        addInfosOverlay(initOverlayData());
    }


    @OnClick({R.id.back_Iv, R.id.my_release_Iv, R.id.confirm_Iv, R.id.map_mode_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.my_release_Iv:
                startActivity(new Intent(LaborServiceCooperationMapActivity.this, LaborServiceCooperationReleaseActivity.class));
                break;
            case R.id.confirm_Iv:
                break;
        }
    }

    List<LaborServiceInfo> initOverlayData() {
        List<LaborServiceInfo> infos = new ArrayList<>();
        infos.add(new LaborServiceInfo(34.242652, 108.971171, R.drawable.maker_icon, "英伦贵族小旅馆",
                "距离209米", "2016-10-23"));
        infos.add(new LaborServiceInfo(34.242952, 108.972171, R.drawable.maker_icon, "沙井国际洗浴会所",
                "距离897米", "2016-10-23"));
        infos.add(new LaborServiceInfo(34.242852, 108.973171, R.drawable.maker_icon, "五环服装城",
                "距离249米", "2016-10-23"));
        infos.add(new LaborServiceInfo(34.242152, 108.971971, R.drawable.maker_icon, "老米家泡馍小炒",
                "距离679米", "2016-10-23"));
        return infos;
    }

    /**
     * 初始化图层
     */
    public void addInfosOverlay(List<LaborServiceInfo> infos) {
        mapView.getMap().clear();
        LatLng latLng = null;
        OverlayOptions overlayOptions = null;
        Marker marker = null;
        for (LaborServiceInfo info : infos) {
            // 位置
            latLng = new LatLng(info.getLatitude(), info.getLongitude());
            // 图标
            //准备 marker 的图片
            BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(info.getImgId());
            overlayOptions = new MarkerOptions().position(latLng)
                    .icon(bitmap);
            marker = (Marker) (mapView.getMap().addOverlay(overlayOptions));
            Bundle bundle = new Bundle();
            bundle.putParcelable("info", info);
            marker.setExtraInfo(bundle);
        }
        // 将地图移到到最后一个经纬度位置
        MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(latLng);
        mapView.getMap().setMapStatus(u);
        initOverlyOnclickListener();
    }


    private void initOverlyOnclickListener() {
        mapView.getMap().setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                View popView = getLayoutInflater().inflate(R.layout.map_marker_pop_layout, null);
                LaborServiceInfo info = (LaborServiceInfo) marker.getExtraInfo().get("info");
                /**
                 *
                 * 在这里处理弹出的信息对应的数据
                 */
                final LatLng ll = marker.getPosition();
                Point p = mapView.getMap().getProjection().toScreenLocation(ll);
                LatLng llInfo = mapView.getMap().getProjection().fromScreenLocation(p);
                InfoWindow mInfoWindow = new InfoWindow(popView, llInfo, -47);
                mapView.getMap().showInfoWindow(mInfoWindow);
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }
}
