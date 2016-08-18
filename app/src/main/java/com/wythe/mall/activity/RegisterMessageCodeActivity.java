package com.wythe.mall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wythe.mall.R;
import com.wythe.mall.utils.Api;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.utils.MallDialog;
import com.wythe.mall.utils.MallDialogFactory;
import com.wythe.mall.utils.StringUtils;
import com.wythe.mall.view.MyEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * Created by wythe on 2016/7/9.
 */
public class RegisterMessageCodeActivity extends BaseActivity {
    private MyEditText edMessageCode;
    private Button btnGetVerifyCode,btnInputNext;
    private TextView tvTip;
    private String phoneNum;
    private String verifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_message_code);
//        Bundle bundle = this.getIntent().getExtras();
//        phoneNum = bundle.getString("phoneNum");
//        verifyCode = bundle.getString("verifyCode");
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        ((TextView)findViewById(R.id.titleText)).setText(R.string.quick_register);
        findViewById(R.id.inputNext).setOnClickListener(this);
        edMessageCode = (MyEditText) findViewById(R.id.input_message_code);
        btnGetVerifyCode = (Button) findViewById(R.id.get_verify_code);
        btnInputNext = (Button) findViewById(R.id.inputNext);
        tvTip = (TextView) findViewById(R.id.tip);
        tvTip.setText(getResources().getString(R.string.regist_pleasedInput)
                + phoneNum
                + getResources().getString(R.string.regist_messageCode));
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.inputNext:{

                GotoActivity.gotoActiviy(RegisterMessageCodeActivity.this,RegisterDetailActivity.class, true);

//                if (TextUtils.equals(verifyCode,edMessageCode.getText().toString().trim())){
//                    Bundle bundle = new Bundle();
//                    bundle.putString("verifyCode",verifyCode);
//                    GotoActivity.gotoActiviy(RegisterMessageCodeActivity.this,RegisterDetailActivity.class,bundle);
//                } else {
//                    Toast.makeText(this,"验证码输入错误",Toast.LENGTH_SHORT).show();
//                }
                break;
            }
            case R.id.get_verify_code:{
                sendMsg();
                break;
            }
        }
    }

    private void sendMsg(){
        OkHttpUtils.post()
                .url(Api.API_SERVER+Api.SENDMSG)
                .addParams("mobile",edMessageCode.getText().toString().trim())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(RegisterMessageCodeActivity.this,"获取验证码失败！",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            Log.i(TAG,response);
                            JSONObject json = new JSONObject(response);

                            int state = json.getInt("state_code");
                            String msg = json.getString("msg");
                            if (state != 200){
                                Toast.makeText(RegisterMessageCodeActivity.this,"获取验证码失败！"+msg,Toast.LENGTH_LONG).show();
                                return ;
                            }
                            String verfiCode = json.getJSONObject("data").getString("code");
                            if (TextUtils.equals(verifyCode,edMessageCode.getText().toString().trim())){
                                GotoActivity.gotoActiviy(RegisterMessageCodeActivity.this,RegisterDetailActivity.class);
                            } else {
                                Toast.makeText(RegisterMessageCodeActivity.this,"验证码输入错误",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        final MallDialog mallDialog = MallDialogFactory.getInstance().createMallDialogWithStyle2(RegisterMessageCodeActivity.this,"退出会中断注册过程，要继续吗？","取消","确定");
        mallDialog.setOnRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mallDialog.dismiss();
            }
        });
        super.onBackPressed();
    }
}
