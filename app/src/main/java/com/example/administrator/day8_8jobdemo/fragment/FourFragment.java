package com.example.administrator.day8_8jobdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.day8_8jobdemo.R;

/**
 * Created by Administrator on 2016/8/8.
 */
public class FourFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_layout, container, false);
        WebView web = (WebView) view.findViewById(R.id.four_webview);
        initData(web);
        return view;
    }

    private void initData(WebView web) {
        //让WebView充当打开网址的客户端，避免打开浏览器访问网址
        web.setWebViewClient(new WebViewClient());
        //让WebView控件支持普通的Javascript语句
        web.getSettings().setJavaScriptEnabled(true);
        //让WebView支持类似alert这样的特殊javascript语句
        web.setWebChromeClient(new WebChromeClient());
        web.loadUrl("http://www.bilibili.com/index.html");

    }
}
