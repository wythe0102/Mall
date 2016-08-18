package com.wythe.mall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wythe.mall.R;
import com.wythe.mall.utils.Api;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.utils.MallDialog;
import com.wythe.mall.utils.MallDialogFactory;
import com.wythe.mall.view.MyEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import okhttp3.Call;

/**
 * Created by wythe on 2016/7/9.
 */
public class RegisterActivity extends BaseActivity {
    public static final String TAG = RegisterActivity.class.getSimpleName();
    private MyEditText etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        ((TextView)findViewById(R.id.titleText)).setText(R.string.quick_register);
        findViewById(R.id.register_button).setOnClickListener(this);
        etPhoneNumber = (MyEditText) findViewById(R.id.register_number_editText);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.register_button:{
                String message = getResources().getString(R.string.regist_sendTo)+"\n\n"+ etPhoneNumber.getText().toString();
                final MallDialog mallDialog = MallDialogFactory.getInstance().createMallDialogWithStyle2(this,message,"取消","确定");
                mallDialog.setOnLeftButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mallDialog.dismiss();
                    }
                });
                //设置右边按钮
                mallDialog.setOnRightButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mallDialog.dismiss();
                        //发送验证码操作
                        //sendMsg();
                        GotoActivity.gotoActiviy(RegisterActivity.this,RegisterMessageCodeActivity.class,true);

                    }
                });
                mallDialog.show();
                break;
            }
        }
    }

    private void sendMsg(){
        OkHttpUtils.post()
                .url(Api.API_SERVER+Api.SENDMSG)
                .addParams("mobile",etPhoneNumber.getText().toString().trim())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(RegisterActivity.this,"获取验证码失败！",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            Log.i(TAG,response);
                            JSONObject json = new JSONObject(response);

                            int state = json.getInt("state_code");
                            String msg = json.getString("msg");
                            if (state != 200){
                                Toast.makeText(RegisterActivity.this,"获取验证码失败！"+msg,Toast.LENGTH_LONG).show();
                                return ;
                            }
                            String verfiCode = json.getJSONObject("data").getString("code");
                            Intent intent = new Intent(RegisterActivity.this,
                                    RegisterMessageCodeActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("phoneNum", etPhoneNumber.getText().toString().trim());
                            bundle.putString("verifyCode", verfiCode);
                            GotoActivity.gotoActiviy(RegisterActivity.this,RegisterMessageCodeActivity.class,bundle);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
