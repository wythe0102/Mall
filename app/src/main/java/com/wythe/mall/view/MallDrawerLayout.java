package com.wythe.mall.view;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class MallDrawerLayout extends DrawerLayout {

	private static final String TAG = "MallDrawerLayout";

	public MallDrawerLayout(Context context) {
		super(context);
	}

	public MallDrawerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MallDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return false;
		}

		return super.onKeyUp(keyCode, event);
	}

}
