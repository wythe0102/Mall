package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.utils.BPUtil;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.view.MyEditText;

/**
 * Created by wythe on 2016/7/10.
 */
public class FindPasswordActivity extends BaseActivity {

    private MyEditText etUserAccount,etVerifyCode;
    private ImageView imgVerifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.find_password);
        etUserAccount = (MyEditText) findViewById(R.id.find_password_account_et);
        etVerifyCode = (MyEditText) findViewById(R.id.find_password_input_verify_input_et);
        findViewById(R.id.next_button).setOnClickListener(this);
        imgVerifyCode = (ImageView) findViewById(R.id.find_password_input_verify_image_new);
        imgVerifyCode.setOnClickListener(this);
        imgVerifyCode.setImageBitmap(BPUtil.getInstance().createBitmap());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.next_button:{
                //TODO 跳转到输入验证码页面
                Bundle bundle = new Bundle();
                bundle.putString("account",etUserAccount.getText().toString().trim());
                GotoActivity.gotoActiviy(FindPasswordActivity.this,FindPasswordMessageCodeActivity.class,bundle);
                break;
            }
            case R.id.find_password_input_verify_image_new:{
                imgVerifyCode.setImageBitmap(BPUtil.getInstance().createBitmap());
                break;
            }
        }
    }
}
