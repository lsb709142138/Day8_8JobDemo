package com.example.administrator.day8_8jobdemo.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.day8_8jobdemo.R;
import com.example.administrator.day8_8jobdemo.adapter.SecondListViewAdapter;
import com.example.administrator.day8_8jobdemo.bean.MyLoveBean;
import com.example.administrator.day8_8jobdemo.ui.DetailActivity;
import com.example.administrator.day8_8jobdemo.ui.LoginActivity;
import com.example.administrator.day8_8jobdemo.ui.MainActivity;
import com.example.administrator.day8_8jobdemo.urlconfig.UrlConfig;
import com.example.administrator.day8_8jobdemo.utils.GetUpdataDao;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class SecondFragment extends Fragment{

    private Toolbar sToolbar;
    private ListView sListView;
    private List<MyLoveBean> myLoveBeen;
    private SecondListViewAdapter adapter;
    private List<MyLoveBean> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.second_fragment_layout, container, false);

        //初始化控件
        initView(view);
        //加载数据

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
    private void initData() {
        try {
            Log.i("TAG","iiiiiiiiiiiiiiiiii");
            mList = new ArrayList<>();

            myLoveBeen = MainActivity.dbUtils.findAll(MyLoveBean.class);
            mList.addAll(myLoveBeen);
            //设置listview的适配器
            adapter = new SecondListViewAdapter(mList);
            sListView.setAdapter(adapter);

        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    //初始化布局
    private void initView(View view) {
        sToolbar = (Toolbar) view.findViewById(R.id.second_fragment_toolbar);
        sListView = (ListView) view.findViewById(R.id.second_fragment_listview);
        //短按跳转
        sListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //启动activity 并传递信息
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.setAction("detail");
                Bundle bundle = new Bundle();
                bundle.putString("comicId",myLoveBeen.get(i).getComicId());
                bundle.putString("url", UrlConfig.DETAIL_PATH);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        //长按删除
        sListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                //创建dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("是否删除？");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                        //删除所选位置的数据
                        try {
                            List<MyLoveBean> all = MainActivity.dbUtils.findAll(MyLoveBean.class);
                            if (all != null){
                                //从数据库中删除数据
                                MainActivity.dbUtils.delete(all.get(i));
                                //移除数据
                                mList.remove(i);
                                adapter.notifyDataSetChanged();
                            }
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //显示对话框
                builder.show();
                return true;
            }
        });

        sToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                // 跳转到登录页面
                startActivity(new Intent(getContext(), LoginActivity.class));

            }
        });
    }
}
