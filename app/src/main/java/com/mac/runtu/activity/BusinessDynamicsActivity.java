package com.mac.runtu.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
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

public class BusinessDynamicsActivity extends AppCompatActivity implements OnClickListener {

    int type = 1;
    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.bd_Lv)
    ListView bdLv;
    Banner banner;
    @BindView(R.id.swipeRefreshLayout)
    PullRefreshLayout swipeRefreshLayout;
    Handler refreshHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(BusinessDynamicsActivity.this, "刷新完毕", Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    @BindView(R.id.menu_LL)
    LinearLayout menuLL;
    @BindView(R.id.release_Iv)
    ImageView releaseIv;

    TextView merchantsReleaseTv;
    TextView householdReleaseTv;
    ImageView confirmIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_dynamics);
        ButterKnife.bind(this);
        initView();
        initBannerData();
        initData();
    }

    void initView() {
        View header = getLayoutInflater().inflate(R.layout.business_dynamics_header_layout, null);
        View floatView = getLayoutInflater().inflate(R.layout.business_dynamics_float_menu_layout, null);
        merchantsReleaseTv = ButterKnife.findById(floatView, R.id.merchants_release_Tv);
        householdReleaseTv = ButterKnife.findById(floatView, R.id.household_release_Tv);
        confirmIv = ButterKnife.findById(floatView, R.id.confirm_Iv);
        merchantsReleaseTv.setOnClickListener(this);
        householdReleaseTv.setOnClickListener(this);
        confirmIv.setOnClickListener(this);
        releaseIv.setOnClickListener(this);
        backIv.setOnClickListener(this);
        banner = ButterKnife.findById(header, R.id.banner);
        bdLv.addHeaderView(header);
        bdLv.addHeaderView(floatView, null, true);
        bdLv.setOnScrollListener(new AbsListView.OnScrollListener() {
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
                Toast.makeText(BusinessDynamicsActivity.this, "开始刷新", Toast.LENGTH_SHORT).show();
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
        for (int i = 0; i < 5; i++) {
            datas.add(i + "");
        }
        int resId = R.layout.business_dynamics_list_item_layout;
        bdLv.setAdapter(new CommonAdapter<String>(BusinessDynamicsActivity.this, resId, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                if (type == 1) {
                    viewHolder.getView(R.id.imageView).setVisibility(View.VISIBLE);
                } else {
                    viewHolder.getView(R.id.imageView).setVisibility(View.GONE);
                }
            }
        });

        bdLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(BusinessDynamicsActivity.this, BusinessDynamicsDetailsActivity.class));
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.merchants_release_Tv:
                merchantsReleaseTv.setBackgroundResource(R.drawable.shape_just_bottom_line_business_dynamics_select_bg);
                householdReleaseTv.setBackgroundResource(R.drawable.shape_just_bottom_line_business_dynamics_normal_bg);
                merchantsReleaseTv.setTextColor(getColor(R.color.titlebg));
                householdReleaseTv.setTextColor(getColor(R.color.normal_color));
                type = 1;
                initData();
                break;
            case R.id.household_release_Tv:
                merchantsReleaseTv.setBackgroundResource(R.drawable.shape_just_bottom_line_business_dynamics_normal_bg);
                householdReleaseTv.setBackgroundResource(R.drawable.shape_just_bottom_line_business_dynamics_select_bg);
                merchantsReleaseTv.setTextColor(getColor(R.color.normal_color));
                householdReleaseTv.setTextColor(getColor(R.color.titlebg));
                type = 2;
                initData();
                break;
            case R.id.confirm_Iv:
                Toast.makeText(BusinessDynamicsActivity.this, "confirm_Iv", Toast.LENGTH_SHORT).show();
                break;
            case R.id.release_Iv:
                startActivity(new Intent(BusinessDynamicsActivity.this, BusinessDynamicsReleaseActivity.class));
                break;
        }
    }
}
