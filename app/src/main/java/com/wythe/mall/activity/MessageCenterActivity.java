package com.wythe.mall.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.adapter.MessageItem;
import com.wythe.mall.utils.GotoActivity;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wythe on 2016/7/17.
 */
public class MessageCenterActivity extends BaseActivity {

    private ListView lvMessage;
    private List<MessageItem> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.message_center);
        lvMessage = (ListView) findViewById(R.id.message_center);
        messageList.add(new MessageItem("#E56A63","易配客服","6:28","点击查看消息记录"));
        messageList.add(new MessageItem("#F1AF4E","我的资产","12:09","昨日收到5张优惠券，优惠额240"));
        messageList.add(new MessageItem("#E6653E","优惠促销","昨天","科牌润滑油10L装最新上市"));
        messageList.add(new MessageItem("#68CE9C","系统通知","6月28日","您有一笔未支付订单即将失效，再不搞定..."));
        messageList.add(new MessageItem("#A57CC8","物流通知","5月23日","您的订单19365192455已完成"));
        lvMessage.setAdapter(new CommonAdapter<MessageItem>(this, R.layout.message_center_item, messageList) {
            @Override
            protected void convert(ViewHolder viewHolder, MessageItem item, int position) {
                View itemView = viewHolder.getConvertView();
                itemView.findViewById(R.id.message_center_item_color).setBackgroundColor(Color.parseColor(item.getItemColor()));
                ((TextView)itemView.findViewById(R.id.message_center_item_type)).setText(item.getItemType());
                ((TextView)itemView.findViewById(R.id.message_center_item_time)).setText(item.getItemTime());
                ((TextView)itemView.findViewById(R.id.message_center_item_summary)).setText(item.getItemSummary());
                if (position == 4){
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            GotoActivity.gotoActiviy(MessageCenterActivity.this, ExpressActivity.class);
                        }
                    });
                }
            }

        });
    }
}
