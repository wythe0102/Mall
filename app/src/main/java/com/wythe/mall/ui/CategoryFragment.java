package com.wythe.mall.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.wythe.mall.R;
import com.wythe.mall.adapter.DataModel;
import com.wythe.mall.adapter.ShopAdapter;


public class CategoryFragment extends Fragment implements View.OnClickListener{

    private LayoutInflater inflater;
    private ViewPager viewPager;
    private ScrollView scrollView;
    private View view;
    private String[] list;
    private ShopAdapter shopAdapter;
    private View[] views;
    private TextView[] textList;
    // 默认的ViewPager选中的项
    private int currentItem = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        initView();
        return view;
    }

    private void initView(){
        scrollView = (ScrollView) view.findViewById(R.id.tools_scrollView);
        viewPager = (ViewPager) view.findViewById(R.id.goods);
        inflater = LayoutInflater.from(getActivity());
        showTools();
        initViewPager();
    }

    /**
     * 左侧栏目选项的内容的显示
     *
     */
    private void showTools() {
        // TODO Auto-generated method stub
        list = DataModel.toolist;
        views = new View[list.length];
        textList = new TextView[list.length];
        LinearLayout toolsLayout = (LinearLayout) view.findViewById(R.id.tools);

        for (int i = 0; i < list.length; i++) {
            View view = inflater.inflate(R.layout.toolslist_layout, null);
            // 给每个View设定唯一标识
            view.setId(i);
            // 给每个view添加点击监控事件
            view.setOnClickListener(toolsItemClickListener);
            // 获取到左侧栏的的TextView的组件
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(list[i]);
            toolsLayout.addView(view);
            // 传入的是地址不是复制的值
            textList[i] = textView;
            views[i] = view;
        }
        // 开始默认是第一个被选中的情况
        changeTextColor(0);

    }

    /**
     * 右侧栏目选项的内容的显示
     */
    private void initViewPager() {
        // TODO Auto-generated method stub
        // 由于使用了支持包所以最终必须确保所有的导入包都是来自支持包
        shopAdapter = new ShopAdapter(getActivity().getSupportFragmentManager(), list);
        viewPager.setAdapter(shopAdapter);
        // 为ViewPager设置页面变化的监控
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    /**
     * ViewPager监控事件处理 监听ViewPager选项卡变化事的事件
     */
    private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            // TODO Auto-generated method stub
            if (viewPager.getCurrentItem() != arg0) {
                viewPager.setCurrentItem(arg0);
            }
            // 通过ViewPager监听点击字体颜色和背景的改变
            if (currentItem != arg0) {
                changeTextColor(arg0);
                changeTextLocation(arg0);
            }
            currentItem = arg0;

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }
    };

    /**
     * 模拟点击时TextView文本字体颜色的改变情况
     *
     *
     * @param id
     */
    private void changeTextColor(int id) {
        // TODO Auto-generated method stub
        for (int i = 0; i < list.length; i++) {
            if (id != i) {
                textList[i].setBackgroundColor(0x00000000);
                textList[i].setTextColor(0xFF000000);
            }
        }
        textList[id].setBackgroundColor(0xFFFFFFFF);
        textList[id].setTextColor(0xFFFF5D5E);

    }

    /**
     * view的点击事件,
     *
     * 通过点击view来是ViewPager的状态发生改变，同时ViewPager监控自己的改变 可以用来处理一些事件的情况
     */
    private View.OnClickListener toolsItemClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            viewPager.setCurrentItem(v.getId());

        }
    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 改变左侧栏选中项的位置
     *
     * @param clickPosition
     */
    private void changeTextLocation(int clickPosition) {
        // TODO Auto-generated method stub
        // 获得点击的view视图距离屏幕顶部的距离
        int y = (views[clickPosition].getTop());
        // 如果滑动条可以滑动的情况下就把点击的视图移动到顶部
        scrollView.smoothScrollTo(0, y);

    }
}
