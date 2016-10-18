package com.mac.runtu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;

import com.leaking.slideswitch.SlideSwitch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/17.
 */
public class PersonalCenterSettingActivity extends AppCompatActivity {
    @BindView(R.id.back_Iv)
    ImageView backIv;
    @BindView(R.id.aboutis_Tr)
    TableRow aboutisTr;
    @BindView(R.id.news_Ss)
    SlideSwitch newsSs;
    @BindView(R.id.suggestion_Tr)
    TableRow suggestionTr;
    @BindView(R.id.help_Tr)
    TableRow helpTr;
    @BindView(R.id.version_Tr)
    TableRow versionTr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_settings);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_Iv, R.id.aboutis_Tr, R.id.suggestion_Tr, R.id.help_Tr, R.id.version_Tr})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_Iv:
                finish();
                break;
            case R.id.aboutis_Tr:
                startActivity(new Intent(PersonalCenterSettingActivity.this, AboutUsActivity.class));
                break;
            case R.id.suggestion_Tr:
                startActivity(new Intent(PersonalCenterSettingActivity.this, SuggestionActivity.class));
                break;
            case R.id.help_Tr:
                startActivity(new Intent(PersonalCenterSettingActivity.this, HelpActivity.class));
                break;
            case R.id.version_Tr:
                startActivity(new Intent(PersonalCenterSettingActivity.this, VersionActivity.class));
                break;
        }
    }
}
