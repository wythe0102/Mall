package com.wythe.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wythe.mall.R;


public class PersonalItemTitle extends RelativeLayout {

    private ImageView icon; //  左侧图标
    private TextView title; // 名称
    private TextView message; // 提示信息
    private ImageView newIcon; // new图标
    private ImageView arrow; // 箭头
    private View topLine; // 顶部线
    private View bottomLine; // 底部线

    int iconId;
    int nameId;
    int messageId;
    int messageTextColorId;
    boolean arrowVisible;
    boolean topLineVisible;
    boolean bottomLineVisible;

    private String currentIcoUrl = "";

    public PersonalItemTitle(Context context) {
        this(context, null);
    }

    public PersonalItemTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.personal_view_item_title, this, true);

        if (isInEditMode()) {
            return;
        }

        icon = (ImageView) findViewById(R.id.personal_item_icon);
        title = (TextView) findViewById(R.id.personal_item_title);
        message = (TextView) findViewById(R.id.personal_item_more_msg);
        newIcon = (ImageView) findViewById(R.id.personal_item_new_icon);
        arrow = (ImageView) findViewById(R.id.personal_item_arrow);
        topLine = findViewById(R.id.personal_item_top_line);
        bottomLine = findViewById(R.id.personal_item_bottom_line);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PersonalItemTitle);
        iconId = array.getResourceId(R.styleable.PersonalItemTitle_personalTitleIcon, NO_ID);
        nameId = array.getResourceId(R.styleable.PersonalItemTitle_personalTitle, NO_ID);
        messageId = array.getResourceId(R.styleable.PersonalItemTitle_personalMessage, NO_ID);
        arrowVisible = array.getBoolean(R.styleable.PersonalItemTitle_personalArrowVisible, true);
        messageTextColorId = array.getResourceId(R.styleable.PersonalItemTitle_personalMessageTextColor, NO_ID);
        topLineVisible = array.getBoolean(R.styleable.PersonalItemTitle_personalTopLineVisible, false);
        bottomLineVisible = array.getBoolean(R.styleable.PersonalItemTitle_personalBottomVisible, false);

        if (iconId != NO_ID) {
            icon.setImageResource(iconId);
        } else {
            icon.setVisibility(View.GONE);
        }

        if (nameId != NO_ID) {
            title.setText(nameId);
        }

        if (messageId != NO_ID) {
            message.setVisibility(View.VISIBLE);
            message.setText(messageId);
        }

        if(messageTextColorId != NO_ID) {
            message.setTextColor(getResources().getColor(messageTextColorId));
        }

        if (arrowVisible) {
            arrow.setVisibility(View.VISIBLE);
        } else {
            arrow.setVisibility(View.INVISIBLE);
        }

        if(topLineVisible) {
            topLine.setVisibility(View.VISIBLE);
        } else {
            topLine.setVisibility(View.GONE);
        }

        if(bottomLineVisible) {
            bottomLine.setVisibility(View.VISIBLE);
        } else {
            bottomLine.setVisibility(View.GONE);
        }

        array.recycle();
    }

    public void setIcon(int resId) {
        icon.setImageResource(resId);
    }

    public void setTitle(CharSequence text) {
        title.setText(text);
    }

    public void setMessage(CharSequence text) {
        message.setVisibility(View.VISIBLE);
        message.setText(text);
    }

    public void setMessageColor(String colorString) {
        try {
            int color = Color.parseColor(colorString);
            message.setTextColor(color);
        } catch (IllegalArgumentException e) {
        } catch (Throwable e) {
        }
    }

    public void setMessageDefaultColor() {
        message.setTextColor(getResources().getColor(R.color.personal_color_more));
    }

    public void setRedPointVisibility(int visibility) {
        newIcon.setVisibility(visibility);
    }

    public ImageView getIconImageView() {
        return  icon;
    }

    public void setCurrentIcoUrl(String icoUrl) {
        currentIcoUrl = icoUrl;
    }

    public String getCurrentIcoUrl() {
        return currentIcoUrl;
    }
}