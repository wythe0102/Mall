package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;

import com.wythe.mall.R;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.view.MyEditText;

/**
 * Created by wythe on 2016/7/10.
 */
public class FindPasswordModifyPasswordActivity extends BaseActivity {

    private MyEditText etHistoryReceiver,etNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password_modify_password);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        etHistoryReceiver = (MyEditText) findViewById(R.id.find_password_history_receiver_et);
        etNewPassword = (MyEditText) findViewById(R.id.find_password_new_password_et);
        findViewById(R.id.find_password_complete_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.find_password_complete_button:{
                //TODO 修改验证码
                GotoActivity.gotoActiviy(FindPasswordModifyPasswordActivity.this,MainActivity.class,true);
            }
        }
    }

}
