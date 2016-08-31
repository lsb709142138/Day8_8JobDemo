package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/10.
 */
public class CharptersBean {
    @SerializedName("title")
    private String title;
    @SerializedName("sid")
    private int sid;
    @SerializedName("id")
    private int id;
    @SerializedName("size")
    private double size;
    @SerializedName("counts")
    private int counts;
    @SerializedName("iszm")
    private int iszm;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getIszm() {
        return iszm;
    }

    public void setIszm(int iszm) {
        this.iszm = iszm;
    }

}
