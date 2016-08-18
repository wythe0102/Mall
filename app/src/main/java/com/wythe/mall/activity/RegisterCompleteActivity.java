package com.wythe.mall.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.view.CountDownTimerView;
import com.wythe.mall.view.OnCountDownTimerListener;

/**
 * Created by wythe on 2016/7/17.
 */
public class RegisterCompleteActivity extends BaseActivity {

    private CountDownTimer countDownTimer;
    private TextView tvCountTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_complete);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.approval_tip);
        tvCountTimer = (TextView) findViewById(R.id.count_timer);
        createCountDownTimer();
        countDownTimer.start();
    }

    /**
     * 创建倒计时
     */
    private void createCountDownTimer() {
        countDownTimer = new CountDownTimer(4000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tvCountTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                GotoActivity.gotoActiviy(RegisterCompleteActivity.this, MainActivity.class, true);
            }
        };
    }
}
