package com.wythe.mall.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wythe.mall.R;


/**
 * @author anumbrella
 * 
 * @date 2015-8-1
 * 
 *       网格view的自定义adapter
 * 
 */
public class GridViewAdapter extends BaseAdapter {

	private Type type;
	private ArrayList<Type> listTypes;
	private Context context;

	private Hoder hoder;

	public GridViewAdapter(Context mContext, ArrayList<Type> list) {
		this.context = mContext;
		this.listTypes = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (listTypes != null && listTypes.size() > 0) {
			return listTypes.size();
		} else {
			return 0;
		}

	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listTypes.get(position);

	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("static-access")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = convertView.inflate(context, R.layout.item_gridview,
					null);
			hoder = new Hoder(convertView);
			convertView.setTag(hoder);
		} else {
			hoder = (Hoder) convertView.getTag();
		}

		if (listTypes != null && listTypes.size() > 0) {
			type = listTypes.get(position);
			hoder.imageView.setBackgroundResource(type.getIcon());
			hoder.textView.setText(type.getTypeName());
		}

		return convertView;
	}

	private static class Hoder {
		private TextView textView;
		private ImageView imageView;

		public Hoder(View view) {
			textView = (TextView) view.findViewById(R.id.typeName_gridView);
			imageView = (ImageView) view.findViewById(R.id.icon_gridView);
		}

	}

}
