package com.wythe.mall.view.holder;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;


public class ShapeHolder {
    private float x = 0, y = 0;
    private ShapeDrawable shape;
    private int color;
    private float alpha = 1f;
    private Paint paint;

    public void setPaint(Paint value) {
        paint = value;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setX(float value) {
        x = value;
    }

    public float getX() {
        return x;
    }

    public void setY(float value) {
        y = value;
    }

    public float getY() {
        return y;
    }

    public void setShape(ShapeDrawable value) {
        shape = value;
    }

    public ShapeDrawable getShape() {
        return shape;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int value) {
        shape.getPaint().setColor(value);
        color = value;

    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        shape.setAlpha((int) ((alpha * 255f) + .5f));
    }

    public float getWidth() {
        return shape.getShape().getWidth();
    }

    public void setWidth(float width) {
        Shape s = shape.getShape();
        s.resize(width, s.getHeight());
    }

    public float getHeight() {
        return shape.getShape().getHeight();
    }

    public void setHeight(float height) {
        Shape s = shape.getShape();
        s.resize(s.getWidth(), height);
    }
    public void resizeShape(final float width,final float height){
        shape.getShape().resize(width,height);
    }
    public ShapeHolder(ShapeDrawable s) {
        shape = s;
    }
}
