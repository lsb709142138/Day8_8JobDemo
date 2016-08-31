package com.example.administrator.day8_8jobdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.bean.GridDataBean;
import com.example.administrator.day8_8jobdemo.bean.PopupWindowBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class PopupWindowAdapter extends BaseAdapter{
    private List<PopupWindowBean.DataBean> mList;
    private ViewHolder holder;

    public PopupWindowAdapter(List<PopupWindowBean.DataBean> list){
        this.mList = list;
        Log.i("TAG","ppppppopoooooooppppppp--->"+mList);
    }
    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mList != null ? mList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popup_window_layout_gridview_item,parent,false);
        }
        holder = getViewHolder(view);
        //解析数据源
        PopupWindowBean.DataBean dataBean = mList.get(i);
        String title = dataBean.getTitle();
        holder.tvTitle.setText(title);

        return view;
    }

    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null){
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    class ViewHolder{
        TextView tvTitle;
        public ViewHolder(View view){
            tvTitle = (TextView) view.findViewById(R.id.popup_text);
        }
    }
}
