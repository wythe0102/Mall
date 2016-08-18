package com.wythe.mall.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class DPIUtil {

	private static float mDensity = DisplayMetrics.DENSITY_DEFAULT;
	private static Display defaultDisplay;

	public static void setDensity(float density) {
		mDensity = density;
		Log.d("DPIUtil", " -->> density=" + density);
	}
	public static float getDensity() {
		return mDensity;
	}
	public static Display getDefaultDisplay() {
		if (null == defaultDisplay) {
			//WindowManager systemService = (WindowManager) BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
			//defaultDisplay = systemService.getDefaultDisplay();
		}
		return defaultDisplay;
	}

	public static int percentWidth(float percent) {
		return (int) (getWidth() * percent);
	}

	public static int percentHeight(float percent) {
		return (int) (getHeight() * percent);
	}

	public static int dip2px(float dipValue) {
		return (int) (dipValue * mDensity + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		return (int) (pxValue / mDensity + 0.5f);
	}

	public static int getWidth() {
		return getDefaultDisplay().getWidth();
	}

	public static int getHeight() {
		return getDefaultDisplay().getHeight();
	}
	
	public static int px2sp(Context context, float pxValue) {  
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;  
        return (int) (pxValue / fontScale + 0.5f);  
    }

    public static int sp2px(Context context, float spValue){
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)((spValue-0.5f)*fontScale);
    }
	
	public static int getWidthByDesignValue(int nDesignValue, int nDesignScreenWidth){
		return getWidth() * nDesignValue / nDesignScreenWidth;
	}
	
	public static int getWidthByDesignValue720(int nDesignValue){
		return getWidthByDesignValue(nDesignValue, 720);
	}

}
