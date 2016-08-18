package com.wythe.mall.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wythe.mall.R;
import com.wythe.mall.activity.LoginActivity;
import com.wythe.mall.activity.MainActivity;
import com.wythe.mall.utils.Constants;
import com.wythe.mall.utils.GotoActivity;
import com.wythe.mall.view.CountDownTimerView;
import com.youth.banner.Banner;


public class HomeFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Banner banner,bannerActivity;
    private CountDownTimerView countDownTimerView;

    Integer[] images = new Integer[]{R.drawable.image01,R.drawable.image02,R.drawable.image03,R.drawable.image04,R.drawable.image05,R.drawable.image06,R.drawable.image07,R.drawable.image08};
    Integer[] images2 = new Integer[]{R.drawable.image03,R.drawable.image04,R.drawable.image05,R.drawable.image06};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return view;
    }

    private void initView(){
        view.findViewById(R.id.login_btn).setOnClickListener(this);
        banner = (Banner) view.findViewById(R.id.home_banner);
        bannerActivity = (Banner) view.findViewById(R.id.home_activity_banner);
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
        //设置样式
        bannerActivity.setBannerStyle(Banner.CIRCLE_INDICATOR);
        bannerActivity.setIndicatorGravity(Banner.CENTER);
        bannerActivity.setDelayTime(5000);//设置轮播间隔时间
        bannerActivity.setImages(images2);//可以选择设置图片网址，或者资源文件，默认用Glide加载
        bannerActivity.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getActivity(),"你点击了："+position,Toast.LENGTH_LONG).show();
            }
        });

        //首页按钮
        view.findViewById(R.id.home_category).setOnClickListener(this);
        view.findViewById(R.id.home_my_like).setOnClickListener(this);
        view.findViewById(R.id.home_my_yipei).setOnClickListener(this);
        view.findViewById(R.id.home_wuliu).setOnClickListener(this);
        view.findViewById(R.id.home_ticket).setOnClickListener(this);
        view.findViewById(R.id.home_bbs).setOnClickListener(this);
        view.findViewById(R.id.home_score).setOnClickListener(this);
        view.findViewById(R.id.home_invoice).setOnClickListener(this);
        view.findViewById(R.id.home_enter_miaosha).setOnClickListener(this);

        countDownTimerView = (CountDownTimerView) view.findViewById(R.id.home_countDownTimerView);
        countDownTimerView.setDownTime(24*60*60*1000);
        countDownTimerView.startDownTimer();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.isAutoPlay(true);
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.isAutoPlay(false);
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:{
                GotoActivity.gotoActiviy(this.getActivity(), LoginActivity.class);
                break;
            }
            case R.id.home_category :{
                ((MainActivity)this.getActivity()).navigateTo(Constants.NAVIGATE_CATEGORY);
                break;
            }
            case R.id.home_my_like :{
                //TODO
                break;
            }
            case R.id.home_my_yipei :{
                //TODO
                break;
            }
            case R.id.home_wuliu :{
                //TODO
                break;
            }
            case R.id.home_ticket :{
                //TODO
                break;
            }
            case R.id.home_bbs :{
                //TODO
                break;
            }
            case R.id.home_score :{
                //TODO
                break;
            }
            case R.id.home_invoice :{
                //TODO
                break;
            }
            case R.id.home_enter_miaosha :{
                //TODO
                break;
            }
        }
    }
}
