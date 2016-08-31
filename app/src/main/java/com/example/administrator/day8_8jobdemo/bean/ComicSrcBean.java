package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ComicSrcBean {

    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private String id;
    @SerializedName("lastCharpterTitle")
    private String lastCharpterTitle;
    @SerializedName("lastCharpterId")
    private String lastCharpterId;
    @SerializedName("lastCharpterUpdateTime")
    private int lastCharpterUpdateTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastCharpterTitle() {
        return lastCharpterTitle;
    }

    public void setLastCharpterTitle(String lastCharpterTitle) {
        this.lastCharpterTitle = lastCharpterTitle;
    }

    public String getLastCharpterId() {
        return lastCharpterId;
    }

    public void setLastCharpterId(String lastCharpterId) {
        this.lastCharpterId = lastCharpterId;
    }

    public int getLastCharpterUpdateTime() {
        return lastCharpterUpdateTime;
    }

    public void setLastCharpterUpdateTime(int lastCharpterUpdateTime) {
        this.lastCharpterUpdateTime = lastCharpterUpdateTime;
    }

}
