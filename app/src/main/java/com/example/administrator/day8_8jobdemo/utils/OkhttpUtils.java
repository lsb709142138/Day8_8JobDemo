package com.example.administrator.day8_8jobdemo.utils;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/8/8.
 */
public class OkhttpUtils {

    public static String getJson(String path){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
        .get()
        .url(path).build();
        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            return json;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
