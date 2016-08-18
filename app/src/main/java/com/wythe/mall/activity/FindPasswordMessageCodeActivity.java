package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.view.MyEditText;

/**
 * Created by wythe on 2016/7/10.
 */
public class FindPasswordMessageCodeActivity extends BaseActivity {

    private TextView tvTip,tvAccountTip;
    private MyEditText etMessageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password_input_message_code);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.find_password);
        tvTip = (TextView) findViewById(R.id.tip);
        tvAccountTip = (TextView) findViewById(R.id.account_name_tip);
        etMessageCode = (MyEditText) findViewById(R.id.input_message_code);
        findViewById(R.id.next_button).setOnClickListener(this);
        findViewById(R.id.get_verify_code).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.next_button:{
                //TODO 检查验证码并跳转到最终充值密码页面
                GotoActivity.gotoActiviy(FindPasswordMessageCodeActivity.this,FindPasswordModifyPasswordActivity.class);
                break;
            }
            case R.id.get_verify_code:{
                //TODO 重新发送验证码
                break;
            }
        }
    }
}
