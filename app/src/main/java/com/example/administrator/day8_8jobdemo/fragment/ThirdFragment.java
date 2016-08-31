package com.example.administrator.day8_8jobdemo.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.ThirdGridAdapter;
import com.example.administrator.day8_8jobdemo.bean.CategaryBean;
import com.example.administrator.day8_8jobdemo.ui.CartoonActivity;
import com.example.administrator.day8_8jobdemo.ui.SeatchActivity;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ThirdFragment extends Fragment {


    private GridView mGrid;
    private List<CategaryBean.DataBean> data;
    private static final int CATAGERY = 8;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CATAGERY:
                    data = (List<CategaryBean.DataBean>) msg.obj;
                    //设置适配器
                    ThirdGridAdapter adapter = new ThirdGridAdapter(data);
                    mGrid.setAdapter(adapter);
                    break;

            }

        }
    };
    private EditText mEdit;
    private ImageView search;
    private String content;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.third_fragment_layout, container, false);
        //初始化布局
        initView(view);
        //加载数据
        initData();
        //设置搜索功能
        doSearch();
        return view;
    }

    private void doSearch() {
        //获取输入的文本


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = mEdit.getText().toString().trim();
                Log.i("TAG","search------------>"+ content);
                //跳转到展示页面
                Intent intent = new Intent(getContext(), SeatchActivity.class);
                intent.putExtra("content", content);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //下载数据
        GetUpdataDao.getCatageryData(UrlConfig.CATEGARYTYPE_PATH, handler, CATAGERY);
    }

    private void initView(View view) {
        //初始化控件
        mEdit = (EditText) view.findViewById(R.id.third_fragment_edit);
        search = (ImageView) view.findViewById(R.id.third_fragment_search);
        mGrid = (GridView) view.findViewById(R.id.third_fragment_gridview);

        //设置点击事件
        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CategaryBean.DataBean dataBean = data.get(i);
                //获取数据
                int cateId = dataBean.getCateId();
                String title = dataBean.getTitle();
                //将id传到列表activity中
                Intent intent = new Intent(getContext(), CartoonActivity.class);
                intent.putExtra("cateid", cateId);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

}
