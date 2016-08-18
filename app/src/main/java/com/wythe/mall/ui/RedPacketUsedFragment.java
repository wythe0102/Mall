package com.wythe.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.adapter.RedPacketItem;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wythe on 2016/7/20.
 */
public class RedPacketUsedFragment extends Fragment {
    private View view;
    private ListView lvRedPacket;
    private List<RedPacketItem> items = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items.add(new RedPacketItem("新用户注册","100","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("朋友赠送","80","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("推荐","50","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("新用户注册","30","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("新用户注册","100","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("朋友赠送","80","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("推荐","50","2016.01.01-2016.06.30"));
        items.add(new RedPacketItem("新用户注册","30","2016.01.01-2016.06.30"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hongbao, container, false);
        initView();
        return view;
    }

    private void initView(){
        lvRedPacket = (ListView) view.findViewById(R.id.list);
        lvRedPacket.setAdapter(new CommonAdapter<RedPacketItem>(getActivity(), R.layout.hongbao_used_item, items) {
            @Override
            protected void convert(ViewHolder viewHolder, RedPacketItem item, int position) {
                View itemView = viewHolder.getConvertView();
                ((TextView)itemView.findViewById(R.id.item_title)).setText(item.getTitle());
                ((TextView)itemView.findViewById(R.id.item_amount)).setText(item.getAmount());
                ((TextView)itemView.findViewById(R.id.item_time)).setText(item.getTime());
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
