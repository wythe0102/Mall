package com.wythe.mall.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.wythe.mall.R;
import com.wythe.mall.utils.Api;
import com.wythe.mall.utils.BPUtil;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.utils.MallUtils;
import com.wythe.mall.view.MyEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelector;
import okhttp3.Call;

import static com.wythe.mall.R.id.company_address_input_et;
import static com.wythe.mall.R.id.company_type_input_et;
import static com.wythe.mall.R.id.interet_product_input_et;

/**
 * Created by wythe on 2016/7/9.
 */
public class RegisterDetailActivity extends BaseActivity {

    public static final String TAG = RegisterDetailActivity.class.getSimpleName();

    private static final int REQUEST_IMAGE_COMPANY_CERTIFICATE = 100;
    private static final int REQUEST_IMAGE_COMPANY_HOME = 200;

    private ArrayList<String> imagePath = new ArrayList<>();
    private ImageView imgCertificate, imgHome, imgVerifyCode;
    private ScrollView scrollView;
    private Bitmap bmpVerifyCode;
    private MyEditText etUsername, etPassword, etConfirmPassword,etContactName,etContactPosition,etContactPhone,etPhone,etEmail,etQQ,etWechat;
    private MyEditText etInteretProduct,etCompanyName, etCompanyLocation,etCompanyAddress,etCompanyType,etVerifyCode;
    private String certificatePhoto = null,homePhoto = null, pageVerifyCode,verifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_detail);
//        Bundle bundle = this.getIntent().getExtras();
//        verifyCode = bundle.getString("verifyCode");
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.quick_register);
        scrollView = (ScrollView) findViewById(R.id.quick_register_layout);
        imgCertificate = (ImageView) findViewById(R.id.company_certificate_photo);
        imgHome = (ImageView) findViewById(R.id.company_home_photo);
        findViewById(R.id.company_certificate_photo_button).setOnClickListener(this);
        findViewById(R.id.company_home_photo_button).setOnClickListener(this);
        imgVerifyCode = (ImageView) findViewById(R.id.register_input_verify_image_new);
        imgVerifyCode.setOnClickListener(this);
        imgVerifyCode.setEnabled(true);
        imgVerifyCode.setImageBitmap(BPUtil.getInstance().createBitmap());
        pageVerifyCode = BPUtil.getInstance().getCode();

        etUsername = (MyEditText) findViewById(R.id.register_input_username_input_et);
        etPassword = (MyEditText) findViewById(R.id.register_input_password_input_et);
        etConfirmPassword = (MyEditText) findViewById(R.id.register_input_password_confirm_input_et);
        etContactName = (MyEditText) findViewById(R.id.contact_name_input_et);
        etContactPosition = (MyEditText) findViewById(R.id.contact_position_input_et);
        etContactPhone = (MyEditText) findViewById(R.id.contact_phone_input_et);
        etPhone = (MyEditText) findViewById(R.id.phone_number_input_et);
        etEmail = (MyEditText) findViewById(R.id.email_input_et);
        etQQ = (MyEditText) findViewById(R.id.qq_input_et);
        etWechat = (MyEditText) findViewById(R.id.wechat_input_et);
        etInteretProduct = (MyEditText) findViewById(interet_product_input_et);
        etCompanyName = (MyEditText) findViewById(R.id.company_name_input_et);
        etCompanyLocation = (MyEditText) findViewById(R.id.company_location_input_et);
        etCompanyAddress = (MyEditText) findViewById(company_address_input_et);
        etCompanyType = (MyEditText) findViewById(company_type_input_et);
        etVerifyCode = (MyEditText) findViewById(R.id.register_input_verify_input_et);

        findViewById(R.id.register_complete_button).setOnClickListener(this);

    }

    private boolean checkRequire() {
        if (TextUtils.isEmpty(etUsername.getText().toString().trim())) {
            Toast.makeText(this, "请填写用户名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
            Toast.makeText(this, "请填写登录密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etConfirmPassword.getText().toString().trim())) {
            Toast.makeText(this, "请填写确认密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!TextUtils.equals(etPassword.getText().toString().trim(),etConfirmPassword.getText().toString().trim())){
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etContactName.getText().toString().trim())) {
            Toast.makeText(this, "请填写联系人姓名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            Toast.makeText(this, "请填写手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etCompanyName.getText().toString().trim())) {
            Toast.makeText(this, "请填写公司名称", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etCompanyLocation.getText().toString().trim())) {
            Toast.makeText(this, "请填写公司所在地", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etCompanyAddress.getText().toString().trim())) {
            Toast.makeText(this, "请填写公司地址", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etCompanyType.getText().toString().trim())) {
            Toast.makeText(this, "请填写公司性质", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etCompanyType.getText().toString().trim())) {
            Toast.makeText(this, "请填写公司性质", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(certificatePhoto)) {
            Toast.makeText(this, "请选择营业执照照片", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(homePhoto)) {
            Toast.makeText(this, "请选择门头照片", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(pageVerifyCode)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!TextUtils.equals(etVerifyCode.getText().toString().trim(), pageVerifyCode)){
            Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.company_certificate_photo_button: {
                pickImage(REQUEST_IMAGE_COMPANY_CERTIFICATE);
                break;
            }
            case R.id.company_home_photo_button: {
                pickImage(REQUEST_IMAGE_COMPANY_HOME);
                break;
            }
            case R.id.register_input_verify_image_new: {
                imgVerifyCode.setImageBitmap(BPUtil.getInstance().createBitmap());
                pageVerifyCode = BPUtil.getInstance().getCode();
                break;
            }
            case R.id.register_complete_button: {
//                if (checkRequire()){
//                    doRegister();
                    GotoActivity.gotoActiviy(this, RegisterCompleteActivity.class, true);
                //               }
                break;
            }
        }
    }

    private void doRegister(){
        OkHttpUtils.post()
                .addParams("username",etUsername.getText().toString().trim()).addParams("password",etPassword.getText().toString().trim())
                .addParams("repassword",etConfirmPassword.getText().toString().trim()).addParams("true_name",etContactName.getText().toString().trim())
                .addParams("position",etContactPosition.getText().toString().trim()).addParams("telephone",etContactPhone.getText().toString())
                .addParams("mobile",etPhone.getText().toString().trim()).addParams("code",verifyCode)
                .addParams("email",etEmail.getText().toString().trim()).addParams("qq",etQQ.getText().toString().trim())
                .addParams("weixin",etWechat.getText().toString().trim()).addParams("love_type",etInteretProduct.getText().toString().trim())
                .addParams("com_name",etCompanyName.getText().toString().trim()).addParams("province",etCompanyLocation.getText().toString().trim())
                .addParams("city","苏州").addParams("area","工业园区")//TODO 界面没有输入的地方
                .addParams("contact_addr",etCompanyAddress.getText().toString().trim()).addParams("vocation",etCompanyType.getText().toString().trim())
                .addFile("page_img","page_img",new File(certificatePhoto))
                .addFile("vivid_img","vivid_img",new File(homePhoto))
                .url(Api.API_SERVER+Api.USERREG)
                .build().execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG,e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        JSONObject json = null;
                        try {
                            Log.e(TAG,response);
                            json = new JSONObject(response);
                            int state = json.getInt("state_code");
                            String msg = json.getString("msg");
                            if (state != 200){
                                Toast.makeText(RegisterDetailActivity.this,msg,Toast.LENGTH_LONG).show();
                                return ;
                            }
                            Toast.makeText(RegisterDetailActivity.this,msg,Toast.LENGTH_LONG).show();
                            GotoActivity.gotoActiviy(RegisterDetailActivity.this,LoginActivity.class,true);

                        } catch (JSONException e) {
                            Log.e(TAG,e.getMessage());
                        }

                    }
                });
    }


    private void pickImage(int requestCode) {
        MultiImageSelector selector = MultiImageSelector.create();
        selector.showCamera(true);
        selector.single();
        selector.origin(imagePath);
        selector.start(RegisterDetailActivity.this, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_COMPANY_CERTIFICATE) {
                imagePath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                certificatePhoto = imagePath.get(0);
                File file = new File(certificatePhoto);
                if (file.exists()) {
                    MallUtils.setImageSrc(imgCertificate, certificatePhoto);
//                    int[] location = new int[2];
//                    imgCertificate.getLocationInWindow(location);
//                    scrollView.smoothScrollTo(location[0],location[1]);
                }
            }
            if (requestCode == REQUEST_IMAGE_COMPANY_HOME) {
                imagePath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                homePhoto = imagePath.get(0);
                File file = new File(homePhoto);
                if (file.exists()) {
                    MallUtils.setImageSrc(imgHome, homePhoto);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != bmpVerifyCode) {
            if (bmpVerifyCode.isRecycled() == false) {
                bmpVerifyCode.recycle();
                bmpVerifyCode = null;
            }
        }

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
