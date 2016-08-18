package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wythe.mall.R;
import com.wythe.mall.utils.GotoActivity;

/**
 * Created by wythe on 2016/7/17.
 */
public class PocketActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.personal_pocket);
        findViewById(R.id.pocket_yue).setOnClickListener(this);
        findViewById(R.id.pocket_yirongdai).setOnClickListener(this);
        findViewById(R.id.pocket_jifen).setOnClickListener(this);
        findViewById(R.id.pocket_hongbao).setOnClickListener(this);
        findViewById(R.id.pocket_ticket).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.pocket_hongbao :{
                GotoActivity.gotoActiviy(this, RedPacketActivity.class);
                break;
            }
            case R.id.pocket_jifen :{
                GotoActivity.gotoActiviy(this, ScoreActivity.class);
                break;
            }
            case R.id.pocket_ticket :{
                GotoActivity.gotoActiviy(this, TicketActivity.class);
                break;
            }
            case R.id.pocket_yirongdai :{
                GotoActivity.gotoActiviy(this, YiRongDaiActivity.class);
                break;
            }
            case R.id.pocket_yue :{
                GotoActivity.gotoActiviy(this, BalanceActivity.class);
                break;
            }
        }
    }
}
