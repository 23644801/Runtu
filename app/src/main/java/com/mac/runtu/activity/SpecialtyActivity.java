package com.mac.runtu.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.mac.runtu.R;
import com.mac.runtu.custom.LocalCharacteristicsGridView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialtyActivity extends AppCompatActivity implements View.OnClickListener {

    Handler refreshHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(SpecialtyActivity.this, "刷新完毕", Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.bd_Lv)
    ListView bdLv;
    @BindView(R.id.swipeRefreshLayout)
    PullRefreshLayout swipeRefreshLayout;
    LinearLayout localRecommendationLL;
    LinearLayout cerealsLL;
    LinearLayout bornAndBredLL;
    LinearLayout productRecommendLL;
    TextView localFeaturesTv;
    LocalCharacteristicsGridView gridView;
    ImageView adIv;
    TextView productsRecommendedTv;
    Banner banner;
    EditText searchTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);
        ButterKnife.bind(this);
        initView();
        initBannerData();
        initListData();
    }

    void initView() {
        View header = getLayoutInflater().inflate(R.layout.business_dynamics_header_layout, null);
        View floatView = getLayoutInflater().inflate(R.layout.specialty_float_menu_layout, null);
        gridView = ButterKnife.findById(floatView, R.id.gridView);
        initGridData();
        localRecommendationLL = ButterKnife.findById(floatView, R.id.local_recommendation_LL);
        cerealsLL = ButterKnife.findById(floatView, R.id.cereals_LL);
        bornAndBredLL = ButterKnife.findById(floatView, R.id.born_and_bred_LL);
        productRecommendLL = ButterKnife.findById(floatView, R.id.product_recommend_LL);
        localFeaturesTv = ButterKnife.findById(floatView, R.id.local_features_Tv);
        productsRecommendedTv = ButterKnife.findById(floatView, R.id.products_recommended_Tv);
        searchTv = ButterKnife.findById(floatView, R.id.search_Tv);
        adIv = ButterKnife.findById(floatView, R.id.ad_Iv);

        localFeaturesTv.setOnClickListener(this);
        cerealsLL.setOnClickListener(this);
        bornAndBredLL.setOnClickListener(this);
        productRecommendLL.setOnClickListener(this);
        localFeaturesTv.setOnClickListener(this);
        productsRecommendedTv.setOnClickListener(this);
        backIv.setOnClickListener(this);

        banner = ButterKnife.findById(header, R.id.banner);
        bdLv.addHeaderView(header);
        bdLv.addHeaderView(floatView, null, true);
        swipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        swipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // start refresh
                Toast.makeText(SpecialtyActivity.this, "开始刷新", Toast.LENGTH_SHORT).show();
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

    void initListData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.specialty_item_layout;
        bdLv.setAdapter(new CommonAdapter<String>(SpecialtyActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.product_details_Bt, getString(R.string.right_arrow));
                viewHolder.setBackgroundColor(R.id.product_details_Bt, Color.TRANSPARENT);
                viewHolder.setTextColor(R.id.product_details_Bt, R.color.number_of_requests_bg);
                viewHolder.setOnClickListener(R.id.product_details_Bt, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                    }
                });
            }
        });

    }


    void initGridData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.local_specialties_grid_item_layout;
        gridView.setAdapter(new CommonAdapter<String>(SpecialtyActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.local_recommendation_LL:
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                break;
            case R.id.cereals_LL:
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                break;
            case R.id.born_and_bred_LL:
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                break;
            case R.id.product_recommend_LL:
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                break;
            case R.id.ad_Iv:
                break;
            case R.id.products_recommended_Tv:
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                break;
            case R.id.local_features_Tv:
                startActivity(new Intent(SpecialtyActivity.this, SpecialtyListActivity.class));
                break;
        }
    }
}
