package com.wythe.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wythe.mall.R;


public class PersonalEmptyView extends LinearLayout {
    
    private ImageView icon;
    private TextView message;
    private TextView subMessage;
    
    int iconId;
    int msgId;
    int subMsgId;
    int msgTextColor;
    float msgTextSize;
    int subMsgTextColor;
    float subMsgTextSize;

    public PersonalEmptyView(Context context) {
        this(context, null);
    }

    public PersonalEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.personal_common_empty_view, this, true);

        if (isInEditMode()) {
            return;
        }
        
        icon = (ImageView) findViewById(R.id.personal_common_empty_icon);
        message = (TextView) findViewById(R.id.personal_common_empty_msg);
        subMessage = (TextView) findViewById(R.id.personal_common_empty_submsg);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.personal_empty);
        iconId = array.getResourceId(R.styleable.personal_empty_empty_icon, NO_ID);
        msgId = array.getResourceId(R.styleable.personal_empty_empty_message, NO_ID);
        subMsgId = array.getResourceId(R.styleable.personal_empty_empty_submessage, NO_ID);
        msgTextColor = array.getColor(R.styleable.personal_empty_empty_message_text_color, Color.BLACK);
        msgTextSize = array.getDimensionPixelSize(R.styleable.personal_empty_empty_message_text_size, 40);
        subMsgTextColor = array.getColor(R.styleable.personal_empty_empty_submessage_text_color,Color.GRAY);
        subMsgTextSize = array.getDimensionPixelSize(R.styleable.personal_empty_empty_submessage_text_size, 32);

        if (iconId != NO_ID) {
            icon.setImageResource(iconId);
        } else {
            icon.setVisibility(View.GONE);
        }

        if (msgId != NO_ID) {
            message.setVisibility(View.VISIBLE);
            message.setText(msgId);
            message.setTextColor(msgTextColor);
            message.setTextSize(TypedValue.COMPLEX_UNIT_PX , msgTextSize);
        }
        if (subMsgId != NO_ID) {
            subMessage.setVisibility(View.VISIBLE);
            subMessage.setText(subMsgId);
            subMessage.setTextColor(subMsgTextColor);
            subMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX , subMsgTextSize);
        }
        
        array.recycle();
        array = null;
        
    }
    
    
    
}
