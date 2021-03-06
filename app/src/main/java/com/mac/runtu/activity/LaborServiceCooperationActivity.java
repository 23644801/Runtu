package com.mac.runtu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.mac.runtu.R;
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
import butterknife.OnClick;

public class LaborServiceCooperationActivity extends AppCompatActivity implements View.OnClickListener{

    Handler refreshHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(LaborServiceCooperationActivity.this, "刷新完毕", Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    Banner banner;
    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.my_release_Iv)
    ImageView myReleaseIv;
    @BindView(R.id.crp_Lv)
    ListView crpLv;
    @BindView(R.id.swipeRefreshLayout)
    PullRefreshLayout swipeRefreshLayout;
    @BindView(R.id.menu_LL)
    LinearLayout menuLL;
    ImageView conformIv;
    ImageView mapModeIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor_service_cooperation);
        ButterKnife.bind(this);
        View header = getLayoutInflater().inflate(R.layout.business_dynamics_header_layout, null);
        View floatView = getLayoutInflater().inflate(R.layout.labor_service_cooperation_float_menu_layout, null);
        banner = ButterKnife.findById(header, R.id.banner);
        conformIv=ButterKnife.findById(floatView,R.id.confirm_Iv);
        mapModeIv=ButterKnife.findById(floatView,R.id.map_mode_Iv);
        initEvent();
        crpLv.addHeaderView(header);
        crpLv.addHeaderView(floatView, null, true);
        initBannerData();
        initData();
        crpLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    menuLL.setVisibility(View.VISIBLE);
                } else {
                    menuLL.setVisibility(View.GONE);
                }
            }
        });


        swipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        swipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // start refresh
                Toast.makeText(LaborServiceCooperationActivity.this, "开始刷新", Toast.LENGTH_SHORT).show();
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

    void initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.labor_service_cooperation_list_item_layout;
        crpLv.setAdapter(new CommonAdapter<String>(LaborServiceCooperationActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
            }
        });


        crpLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LaborServiceCooperationActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
                if (position >= 2) {
                    startActivity(new Intent(LaborServiceCooperationActivity.this, LaborServiceCooperationDetailsActivity.class));
                }
            }
        });
    }

    void  initEvent(){
        backIv.setOnClickListener(this);
        myReleaseIv.setOnClickListener(this);
        mapModeIv.setOnClickListener(this);
        conformIv.setOnClickListener(this);
    }

    @Override
    @OnClick({R.id.back_Iv, R.id.my_release_Iv, R.id.confirm_Iv, R.id.map_mode_Iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.my_release_Iv:
                startActivity(new Intent(LaborServiceCooperationActivity.this,LaborServiceCooperationReleaseActivity.class));
                break;
            case R.id.confirm_Iv:
                break;
            case R.id.map_mode_Iv:
                startActivity(new Intent(LaborServiceCooperationActivity.this,LaborServiceCooperationMapActivity.class));
                break;
        }
    }
}
