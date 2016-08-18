package com.wythe.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wythe.mall.R;


public class PersonalOrderItem extends RelativeLayout {

    private ImageView icon; //  图标
    private TextView name; // 名称
    private TextView message; // 提示信息

    int iconId;
    int nameId;
    int messageId;

    private String currentIcoUrl = "";

    public PersonalOrderItem(Context context) {
        this(context, null);
    }

    public PersonalOrderItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.personal_view_order_item, this, true);

        if (isInEditMode()) {
            return;
        }

        icon = (ImageView) findViewById(R.id.personal_order_item_icon);
        name = (TextView) findViewById(R.id.personal_order_item_name);
        message = (TextView) findViewById(R.id.personal_order_item_notify);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PersonalOrderItem);
        iconId = array.getResourceId(R.styleable.PersonalOrderItem_order_icon, NO_ID);
        nameId = array.getResourceId(R.styleable.PersonalOrderItem_order_name, NO_ID);
        messageId = array.getResourceId(R.styleable.PersonalOrderItem_order_message, NO_ID);

        if (iconId != NO_ID) {
            icon.setImageResource(iconId);
        }

        if (nameId != NO_ID) {
            name.setText(nameId);
        }

        if (messageId != NO_ID) {
            message.setVisibility(View.VISIBLE);
            message.setText(messageId);
        }

        array.recycle();
    }

    public void setIcon(int resId) {
        icon.setImageResource(resId);
    }

    public void setName(CharSequence text) {
        name.setText(text);
    }

    public void setMessage(CharSequence text) {
        message.setVisibility(View.VISIBLE);
        message.setText(text);
    }

    public void setMessageVisibility(int visilibity) {
        message.setVisibility(visilibity);
    }

    public ImageView getIconImageView() {
        return icon;
    }

    public void setCurrentIcoUrl(String icoUrl) {
        currentIcoUrl = icoUrl;
    }

    public String getCurrentIcoUrl() {
        return currentIcoUrl;
    }
}