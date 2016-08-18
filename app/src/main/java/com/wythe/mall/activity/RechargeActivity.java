package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.wythe.mall.R;

/**
 * Created by wythe on 2016/7/17.
 */
public class RechargeActivity extends BaseActivity {

    private CheckBox cbAlipay,cbQQ,cbWechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.recharge);
        cbAlipay = (CheckBox)findViewById(R.id.recharge_alipay);
        cbQQ = (CheckBox) findViewById(R.id.recharge_qq);
        cbWechat = (CheckBox) findViewById(R.id.recharge_wechat);
        findViewById(R.id.recharge_comfirm_button).setOnClickListener(this);
        initListener();
    }

    @Override
    protected void initListener() {
        super.initListener();
        cbAlipay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbQQ.setChecked(false);
                    cbWechat.setChecked(false);
                }
            }
        });
        cbQQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbAlipay.setChecked(false);
                    cbWechat.setChecked(false);
                }
            }
        });
        cbWechat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbAlipay.setChecked(false);
                    cbQQ.setChecked(false);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.recharge_comfirm_button:{
                //TODO 充值
                break;
            }
        }
    }
}
