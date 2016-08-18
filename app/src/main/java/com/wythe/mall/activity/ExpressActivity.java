package com.wythe.mall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.wythe.mall.R;
import com.wythe.mall.adapter.ExpressItem;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wythe on 2016/7/22.
 */
public class ExpressActivity extends BaseActivity implements View.OnClickListener{

    private ListView lvMessages;
    private List<ExpressItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.title_left_button).setOnClickListener(this);
        super.setNormalTitle(R.string.express_message);
        lvMessages = (ListView) findViewById(R.id.express_list);
        items.add(new ExpressItem("2016年6月10日 11:20","","您的订单19705189930已完成，感谢您对易配的支持，欢迎再次光临。期待您对本次购物进行评价。"));
        items.add(new ExpressItem("2016年6月10日 11:20","","您的订单19705189930已完成，感谢您对易配的支持，欢迎再次光临。期待您对本次购物进行评价。"));
        items.add(new ExpressItem("2016年6月10日 11:20","","您的订单19705189930已完成，感谢您对易配的支持，欢迎再次光临。期待您对本次购物进行评价。"));
        items.add(new ExpressItem("2016年6月10日 11:20","","您的订单19705189930已完成，感谢您对易配的支持，欢迎再次光临。期待您对本次购物进行评价。"));
        items.add(new ExpressItem("2016年6月10日 11:20","","您的订单19705189930已完成，感谢您对易配的支持，欢迎再次光临。期待您对本次购物进行评价。"));
        lvMessages.setAdapter(new CommonAdapter<ExpressItem>(this, R.layout.express_item, items) {
            @Override
            protected void convert(ViewHolder viewHolder, ExpressItem item, int position) {
                View itemView = viewHolder.getConvertView();
                //TODO 绑定内容
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.title_left_button:{
                finish();
                break;
            }
        }
    }
}
