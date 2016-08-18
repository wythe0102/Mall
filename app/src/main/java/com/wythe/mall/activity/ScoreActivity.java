package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;

import com.wythe.mall.R;

/**
 * Created by wythe on 2016/7/17.
 */
public class ScoreActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.score);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
