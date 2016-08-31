package com.example.administrator.day8_8jobdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.day8_8jobdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder>{

    private List<String> mList;

    private Context context;
    private final LayoutInflater inflater;

    //设置接口回调 页面的位置
    public interface OnRecycleViewItemPosition{
        void onItemPosition(int position);
    }
    private OnRecycleViewItemPosition mListener;

    public void setOnItemPosition(OnRecycleViewItemPosition listener){
        this.mListener = listener;
    }
    public MyRecycleAdapter(Context context,List<String> addrs){
        this.context = context;
        this.mList = addrs;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //添加布局
        View view = inflater.inflate(R.layout.mh_recycleview_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String s = mList.get(position);
        Glide.with(context).load(s).into(holder.image);
        //监听页面的位置信息
        if (mListener != null){
            mListener.onItemPosition(position);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.mh_recycle_image);

        }
    }
}
