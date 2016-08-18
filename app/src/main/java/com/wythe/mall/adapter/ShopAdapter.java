package com.wythe.mall.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wythe.mall.ui.TypeFragment;

/**
 * @author anumbrella
 * 
 * @date 2015-8-1
 * 
 *       fragment的适配器(右侧ViewPager加载选项卡)
 * 
 *       Fragment对象会一直存留在内存中，所以当有大量的显示页时，就不适合用FragmentPagerAdapter
 *       了，FragmentPagerAdapter 适用于只有少数的page情况，像选项卡
 * 
 */
public class ShopAdapter extends FragmentPagerAdapter {

	public ShopAdapter(FragmentManager fragmentManager, String[] array) {
		super(fragmentManager);
		// TODO Auto-generated constructor stub
		this.list = array;
	}

	private String[] list;

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		Fragment fragment = new TypeFragment();
		Bundle bundle = new Bundle();
		// 把选中的index指针传入过去
		bundle.putInt("index", index);
		// 设定在fragment当中去
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.length;
	}

}
