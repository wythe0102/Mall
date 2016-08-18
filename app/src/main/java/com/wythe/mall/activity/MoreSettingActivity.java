package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;

import com.wythe.mall.R;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.utils.UserManager;

/**
 * Created by wythe on 2016/7/17.
 */
public class MoreSettingActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_setting);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.more_settings);
        findViewById(R.id.logout_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.logout_button:{
                UserManager.getInstance().setLogin(false);
                GotoActivity.gotoActiviy(this, MainActivity.class, true);
                //TODO 退出登录请求
                break;
            }
        }
    }
}
