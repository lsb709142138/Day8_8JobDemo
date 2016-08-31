package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MHBean {

    /**
     * status : 0
     * data : {"charpterId":11,"title":"第06话","sid":6,"updateTime":1427183785,"counts":47,"size":8.46,"addrs":["http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/001.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/002.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/003.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/004.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/005.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/006.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/007.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/008.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/009.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/010.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/011.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/012.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/013.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/014.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/015.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/016.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/017.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/018.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/019.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/020.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/021.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/022.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/023.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/024.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/025.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/026.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/027.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/028.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/029.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/030.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/031.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/032.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/033.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/034.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/035.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/036.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/037.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/038.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/039.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/040.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/041.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/042.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/043.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/044.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/045.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/046.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/047.jpg"],"surl":"http://manhua.dmzj.com/yueliangshijieyugeji/34868.shtml","iszm":0}
     */

    @SerializedName("status")
    private int status;
    /**
     * charpterId : 11
     * title : 第06话
     * sid : 6
     * updateTime : 1427183785
     * counts : 47
     * size : 8.46
     * addrs : ["http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/001.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/002.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/003.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/004.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/005.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/006.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/007.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/008.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/009.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/010.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/011.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/012.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/013.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/014.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/015.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/016.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/017.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/018.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/019.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/020.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/021.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/022.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/023.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/024.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/025.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/026.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/027.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/028.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/029.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/030.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/031.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/032.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/033.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/034.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/035.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/036.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/037.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/038.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/039.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/040.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/041.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/042.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/043.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/044.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/045.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/046.jpg","http://images.dmzj.com/y/%E6%9C%88%E4%BA%AE%E3%80%81%E4%B8%96%E7%95%8C%E4%B8%8E%E6%AD%8C%E5%A7%AC/%E7%AC%AC06%E8%AF%9D/047.jpg"]
     * surl : http://manhua.dmzj.com/yueliangshijieyugeji/34868.shtml
     * iszm : 0
     */

    @SerializedName("data")
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("charpterId")
        private int charpterId;
        @SerializedName("title")
        private String title;
        @SerializedName("sid")
        private int sid;
        @SerializedName("updateTime")
        private int updateTime;
        @SerializedName("counts")
        private int counts;
        @SerializedName("size")
        private double size;
        @SerializedName("surl")
        private String surl;
        @SerializedName("iszm")
        private int iszm;
        @SerializedName("addrs")
        private List<String> addrs;

        public int getCharpterId() {
            return charpterId;
        }

        public void setCharpterId(int charpterId) {
            this.charpterId = charpterId;
        }

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

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public String getSurl() {
            return surl;
        }

        public void setSurl(String surl) {
            this.surl = surl;
        }

        public int getIszm() {
            return iszm;
        }

        public void setIszm(int iszm) {
            this.iszm = iszm;
        }

        public List<String> getAddrs() {
            return addrs;
        }

        public void setAddrs(List<String> addrs) {
            this.addrs = addrs;
        }
    }
}
