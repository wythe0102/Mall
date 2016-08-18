package com.wythe.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.adapter.TicketItem;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wythe on 2016/7/20.
 */
public class TicketOutDateFragment extends Fragment implements OnClickListener{

    private View view;
    private ListView lvTicket;
    private List<TicketItem> items = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items.add(new TicketItem("新用户注册礼券","100","2016.01.01-2016.06.30","部分商品","满1500元可用"));
        items.add(new TicketItem("新用户注册礼券","100","2016.01.01-2016.06.30","部分商品","满1500元可用"));
        items.add(new TicketItem("新用户注册礼券","100","2016.01.01-2016.06.30","部分商品","满1500元可用"));
        items.add(new TicketItem("新用户注册礼券","100","2016.01.01-2016.06.30","部分商品","满1500元可用"));
        items.add(new TicketItem("新用户注册礼券","100","2016.01.01-2016.06.30","部分商品","满1500元可用"));
        items.add(new TicketItem("新用户注册礼券","100","2016.01.01-2016.06.30","部分商品","满1500元可用"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ticket, container, false);
        initView();
        return view;
    }

    private void initView(){
        lvTicket = (ListView) view.findViewById(R.id.list);
        lvTicket.setAdapter(new CommonAdapter<TicketItem>(getActivity(), R.layout.ticket_used_item, items) {
            @Override
            protected void convert(ViewHolder viewHolder, TicketItem item, int position) {
                View itemView = viewHolder.getConvertView();
                ((TextView)itemView.findViewById(R.id.item_title)).setText(item.getTitle());
                ((TextView)itemView.findViewById(R.id.item_amount)).setText(item.getAmount());
                ((TextView)itemView.findViewById(R.id.item_time)).setText(item.getTime());
                ((TextView)itemView.findViewById(R.id.ticket_info_top)).setText(item.getTopInfo());
                ((TextView)itemView.findViewById(R.id.ticket_info_below)).setText(item.getBelowInfo());
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

    }
}
