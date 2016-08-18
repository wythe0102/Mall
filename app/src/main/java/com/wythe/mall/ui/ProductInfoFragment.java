package com.wythe.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wythe.mall.R;
import com.wythe.mall.view.CircleIndicator;
import com.wythe.mall.view.CountDownTimerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wythe on 2016/7/24.
 */
public class ProductInfoFragment extends Fragment {
    private View view;
    private Banner banner;
    private CountDownTimerView countDownTimerView;
    private CircleIndicator circleIndicator;
    private ViewPager vpSuggestion;
    List<Fragment> list = new ArrayList<>();
    Integer[] images = new Integer[]{R.drawable.message_item,R.drawable.message_item,R.drawable.message_item,R.drawable.message_item};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_info, container, false);
        initView();
        return view;
    }

    protected void initView(){
        banner = (Banner) view.findViewById(R.id.home_banner);
        //设置样式
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(Banner.CENTER);
        banner.setDelayTime(5000);//设置轮播间隔时间
        banner.setImages(images);//可以选择设置图片网址，或者资源文件，默认用Glide加载
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getActivity(),"你点击了："+position,Toast.LENGTH_LONG).show();
            }
        });

        countDownTimerView = (CountDownTimerView) view.findViewById(R.id.product_countDownTimerView);
        countDownTimerView.setDownTime(24*60*60*1000);
        countDownTimerView.startDownTimer();

        vpSuggestion = (ViewPager) view.findViewById(R.id.suggestion_viewpager);
        circleIndicator = (CircleIndicator) view.findViewById(R.id.suggestion_indicator);
        list.add(new SuggestionFragment());
        list.add(new SuggestionFragment());
        list.add(new SuggestionFragment());
        list.add(new SuggestionFragment());
        vpSuggestion.setAdapter(new FragmentPagerAdapter(this.getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        circleIndicator.setViewPager(vpSuggestion);

    }
}
