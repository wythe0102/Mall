package com.wythe.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wythe.mall.R;


public class PersonalPocketItem extends RelativeLayout {

    private TextView name;
    private TextView value;
    private View redPoint;

    int nameId;
    int valueId;

    public PersonalPocketItem(Context context) {
        this(context, null);
    }

    public PersonalPocketItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.personal_view_pocket_item, this, true);

        if (isInEditMode()) {
            return;
        }

        name = (TextView) findViewById(R.id.personal_pocket_name);
        value = (TextView) findViewById(R.id.personal_pocket_value);
        redPoint = findViewById(R.id.personal_pocket_red_point);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PersonalPocketItem);
        nameId = array.getResourceId(R.styleable.PersonalPocketItem_pocket_name, NO_ID);
        valueId = array.getResourceId(R.styleable.PersonalPocketItem_pocket_value, NO_ID);

        if (nameId != NO_ID) {
            name.setText(nameId);
        }

        if (valueId != NO_ID) {
            value.setText(valueId);
        }


        array.recycle();
    }

    public void setName(CharSequence text) {
        name.setText(text);
    }

    public void setValue(CharSequence text) {
        value.setText(text);
    }

    public void setPointVisibility(int visibility) {
        redPoint.setVisibility(visibility);
    }
}