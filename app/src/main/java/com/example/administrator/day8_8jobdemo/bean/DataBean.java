package com.example.administrator.day8_8jobdemo.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/8/9.
 */

public class DataBean {

    @com.google.gson.annotations.SerializedName("title")
    private String title;
    @com.google.gson.annotations.SerializedName("recom_type")
    private String recomType;
    @com.google.gson.annotations.SerializedName("recom_return")
    private String recomReturn;
    @com.google.gson.annotations.SerializedName("thumb")
    private String thumb;
    @com.google.gson.annotations.SerializedName("recom_index")
    private String recomIndex;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecomType() {
        return recomType;
    }

    public void setRecomType(String recomType) {
        this.recomType = recomType;
    }

    public String getRecomReturn() {
        return recomReturn;
    }

    public void setRecomReturn(String recomReturn) {
        this.recomReturn = recomReturn;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getRecomIndex() {
        return recomIndex;
    }

    public void setRecomIndex(String recomIndex) {
        this.recomIndex = recomIndex;
    }

}

