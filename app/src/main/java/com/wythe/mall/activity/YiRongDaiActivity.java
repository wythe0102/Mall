package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;

import com.wythe.mall.R;

/**
 * Created by wythe on 2016/7/17.
 */
public class YiRongDaiActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yirongdai);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.yirongdai);
        findViewById(R.id.yirongdai_add_amount).setOnClickListener(this);
        findViewById(R.id.yirongdai_more_information).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.yirongdai_add_amount:{
                break;
            }
            case R.id.yirongdai_more_information:{
                break;
            }
        }
    }
}
