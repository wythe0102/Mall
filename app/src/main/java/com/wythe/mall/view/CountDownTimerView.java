package com.wythe.mall.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by wythe on 2016/7/12.
 */
public class CountDownTimerView extends BaseCountDownTimerView {
    public CountDownTimerView(Context context) {
        super(context);
    }

    public CountDownTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownTimerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected String getStrokeColor() {
        return "030303";
    }

    @Override
    protected String getTextColor() {
        return "FCFCFC";
    }

    @Override
    protected int getCornerRadius() {
        return 1;
    }

    @Override
    protected int getTextSize() {
        return 40;
    }

    @Override
    protected String getBackgroundColor() {
        return "030303";
    }
}
