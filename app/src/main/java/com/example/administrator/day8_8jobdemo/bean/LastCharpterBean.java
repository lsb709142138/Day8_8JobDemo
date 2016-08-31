package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/9.
 */

public class LastCharpterBean {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

