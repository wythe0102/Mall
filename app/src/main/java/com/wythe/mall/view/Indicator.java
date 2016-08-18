package com.wythe.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wythe.mall.R;

/**
 * Created by Admin on 2016/4/7.
 */
public class Indicator extends LinearLayout {

    private int mWidth;
    private int mHeight = 5;
    private int mTop;
    private int mLeft;
    private int mColor;
    private int mChildCount;
    private int pos;
    private Paint mPaint;

    public Indicator(Context context) {
        this(context, null);
    }

    public Indicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Indicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //setBackgroundColor(Color.TRANSPARENT);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Indicator, 0, 0);
        mColor = array.getColor(R.styleable.Indicator_indicatorColor, Color.RED);
        array.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mChildCount = getChildCount();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mTop = getMeasuredHeight();
        int width = getMeasuredWidth();
        int height = mTop + mHeight;
        mWidth = width / mChildCount;
        setMeasuredDimension(width,height);
    }

    public void scroll(int position,float offset){
        mLeft = (int) ((position + offset) * mWidth);
        pos = position;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(mLeft,mTop,mLeft + mWidth,mTop + mHeight);
        canvas.drawRect(rect, mPaint);
        resetColor();
        TextView tv = (TextView) getChildAt(pos);
        tv.setTextColor(Color.RED);
    }

    private void resetColor() {
        for (int i = 0;i < mChildCount;i++){
            TextView tv = (TextView) getChildAt(i);
            tv.setTextColor(Color.BLACK);
        }
    }
}
