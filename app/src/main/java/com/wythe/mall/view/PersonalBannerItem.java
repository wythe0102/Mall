package com.wythe.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wythe.mall.R;


public class PersonalBannerItem extends LinearLayout {

    private View valueRoot;
    private TextView title; // 名称
    private TextView value; // 值
    private ImageView icon; // 图标

    int titleId;

    public PersonalBannerItem(Context context) {
        this(context, null);
    }

    public PersonalBannerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.personal_view_banner_item, this, true);

        if (isInEditMode()) {
            return;
        }

        valueRoot = findViewById(R.id.personal_banner_value_root);
        icon = (ImageView) findViewById(R.id.personal_banner_icon);
        title = (TextView) findViewById(R.id.personal_banner_title);
        value = (TextView) findViewById(R.id.personal_banner_value);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PersonalBannerItem);
        titleId = array.getResourceId(R.styleable.PersonalBannerItem_banner_title, NO_ID);

        if (titleId != NO_ID) {
            title.setText(titleId);
        }

        array.recycle();
    }

    public void setValueRootVisibility(int visibility) {
        valueRoot.setVisibility(visibility);
    }

    public void setTitle(CharSequence text) {
        title.setText(text);
    }

    public void setTitleTextSize(float size) {
        title.setTextSize(size);
    }

    public void setValue(CharSequence text) {
        value.setText(text);
    }

    public void setRedPointVisibility(int visibility) {
        icon.setVisibility(visibility);
    }

    public boolean isRedPointVisible() {
        return  icon.getVisibility() == View.VISIBLE;
    }
}