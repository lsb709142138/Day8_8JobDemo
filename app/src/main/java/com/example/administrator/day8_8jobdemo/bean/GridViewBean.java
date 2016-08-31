package com.example.administrator.day8_8jobdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class GridViewBean {


    /**
     * status : 0
     * data : [{"title":"普通的恋子酱","thumb":"http://csimg.dm300.com/images/spider/20160408/14600893388991.jpg","comicId":"50671","authorName":"七路眺(ななじ眺)","comicType":"爱情,搞笑,校园","lastCharpter":{"id":"2007555","title":"普通的恋子酱 009集"}},{"title":"哈莉的小黑本","thumb":"http://csimg.dm300.com/images/spider/20160118/14530850539096.jpg","comicId":"49382","authorName":"DC,Comics","comicType":"科幻,冒险,魔幻,热血","lastCharpter":{"id":"2007594","title":"第3卷"}},{"title":"咖菲侦探部","thumb":"http://csimg.dm300.com/images/spider/20150324/14271851033818.jpg","comicId":"1245","authorName":"藤代健","comicType":"搞笑,侦探,校园","lastCharpter":{"id":"2007592","title":"第77话"}},{"title":"御用甜品屋","thumb":"http://csimg.dm300.com/images/spider/20160721/14690868107196.jpg","comicId":"52348","authorName":"漫域","comicType":"热血","lastCharpter":{"id":"2007531","title":"BOOM（中）"}},{"title":"恐·人","thumb":"http://csimg.dm300.com/images/spider/20160322/14586169337156.jpg","comicId":"50358","authorName":"森よし","comicType":"科幻,热血","lastCharpter":{"id":"2007591","title":"第9话"}},{"title":"我的氪金女友","thumb":"http://csimg.dm300.com/images/spider/20160125/14536957348274.jpg","comicId":"49489","authorName":"近江のこ","comicType":"爱情,科幻,热血","lastCharpter":{"id":"1982747","title":"四格番外6"}},{"title":"想让可爱的上司为我困扰","thumb":"http://csimg.dm300.com/images/spider/20160706/14677978262697.jpg","comicId":"52146","authorName":"タチバナロク","comicType":"爱情,热血,综合其他","lastCharpter":{"id":"2007554","title":"为我困扰 007集"}},{"title":"特殊兴趣S的葛藤","thumb":"http://csimg.dm300.com/images/spider/20160809/14707282285565.jpg","comicId":"52645","authorName":"作乐口ク","comicType":"综合其他","lastCharpter":{"id":"2007573","title":"S的葛藤 001集"}},{"title":"和猫耳老公结婚了","thumb":"http://csimg.dm300.com/images/spider/20160809/14707282273805.jpg","comicId":"52644","authorName":"真己京子","comicType":"综合其他","lastCharpter":{"id":"2007570","title":"和猫耳老公结婚了 001集"}},{"title":"白领武馆","thumb":"http://csimg.dm300.com/images/spider/20160613/14658156032752.jpg","comicId":"51816","authorName":"诺动漫工作室","comicType":"热血","lastCharpter":{"id":"2007539","title":"第13话 龙氏太极"}},{"title":"求求你，吃我吧","thumb":"http://csimg.dm300.com/images/spider/20160517/14634888059848.jpg","comicId":"51350","authorName":"抖动文化","comicType":"热血","lastCharpter":{"id":"2007545","title":"第33话"}},{"title":"史上最强BOSS就是本大爷","thumb":"http://csimg.dm300.com/images/spider/20160517/14634888031014.jpg","comicId":"51348","authorName":"SF轻小说","comicType":"热血","lastCharpter":{"id":"2007546","title":"第29话"}},{"title":"基因猎人","thumb":"http://csimg.dm300.com/images/spider/20151124/14483700034595.jpg","comicId":"48206","authorName":"游益互娱","comicType":"热血","lastCharpter":{"id":"2007548","title":"第55话 猫之复仇（下）"}},{"title":"我家大师兄脑子有坑","thumb":"http://csimg.dm300.com/images/spider/20150807/14389312907366.jpg","comicId":"46598","authorName":"剧象漫画","comicType":"搞笑,魔幻","lastCharpter":{"id":"2007547","title":"第163话"}},{"title":"旋风管家","thumb":"http://csimg.dm300.com/images/spider/20150324/14271848416902.jpg ","comicId":"572","authorName":"畑健二郎","comicType":"搞笑,后宫","lastCharpter":{"id":"2007549","title":"第539话修"}},{"title":"龙朝大都","thumb":"http://csimg.dm300.com/images/spider/20160729/14697852046533.jpg","comicId":"52479","authorName":"霖羯/日更计划","comicType":"热血","lastCharpter":{"id":"2007542","title":"第05话上"}},{"title":"毒鼓","thumb":"http://csimg.dm300.com/images/spider/20160601/14647188027873.jpg","comicId":"51595","authorName":"meen&白承勋/良筑良作","comicType":"热血","lastCharpter":{"id":"2007543","title":"第32话"}},{"title":"欢迎来到三次元！","thumb":"http://csimg.dm300.com/images/spider/20160517/14634888054162.jpg","comicId":"51351","authorName":"黑白漫文化","comicType":"热血","lastCharpter":{"id":"2007540","title":"第10话1"}},{"title":"断头岛","thumb":"http://csimg.dm300.com/images/spider/20160420/14611608099461.jpg","comicId":"50893","authorName":"游益互娱","comicType":"侦探","lastCharpter":{"id":"2007541","title":"第17话 争端再起"}},{"title":"凹凸世界","thumb":"http://csimg.dm300.com/images/spider/20150615/14343650836055.jpg","comicId":"34868","authorName":"七创社","comicType":"武侠格斗,热血","lastCharpter":{"id":"2007544","title":"第53话"}},{"title":"最近小便有点甜","thumb":"http://csimg.dm300.com/images/spider/20160729/14697828028748.jpg","comicId":"52474","authorName":"冰狐动漫","comicType":"热血","lastCharpter":{"id":"2007536","title":"第12话 儿子的自信"}},{"title":"爱上一个球","thumb":"http://csimg.dm300.com/images/spider/20160529/14645232023961.jpg","comicId":"51542","authorName":"高能漫画","comicType":"热血","lastCharpter":{"id":"2007538","title":"第35话"}},{"title":"非正常大冒险","thumb":"http://csimg.dm300.com/images/spider/20160514/14632284051230.jpg","comicId":"51264","authorName":"蓝鱼漫画","comicType":"热血","lastCharpter":{"id":"2007537","title":"第23话（上）"}},{"title":"黑鸡汤","thumb":"http://csimg.dm300.com/images/spider/20160621/14664804043967.jpg","comicId":"51927","authorName":"镭暴工作室","comicType":"热血","lastCharpter":{"id":"2007535","title":"七夕篇《银河小镇》"}},{"title":"拖稿的勇者","thumb":"http://csimg.dm300.com/images/spider/20160729/14697828034496.jpg","comicId":"52475","authorName":"高能漫画","comicType":"热血","lastCharpter":{"id":"2007532","title":"第4话"}},{"title":"斗罗大陆3龙王传说","thumb":"http://csimg.dm300.com/images/spider/20151230/14514241326448.jpg","comicId":"48971","authorName":"未知","comicType":"魔幻,热血","lastCharpter":{"id":"2007529","title":"第11话（1）"}},{"title":"平凡士兵梦回过去","thumb":"http://csimg.dm300.com/images/spider/20160808/14706252259961.jpg","comicId":"52632","authorName":"丘野优","comicType":"冒险,魔幻,热血","lastCharpter":{"id":"2007559","title":"平凡士兵梦回过去 002集"}},{"title":"新52哈莉·奎茵","thumb":"http://csimg.dm300.com/images/spider/20150324/14271868257838.jpg","comicId":"11522","authorName":"DC Comics","comicType":"科幻,冒险","lastCharpter":{"id":"1945768","title":"16卷"}},{"title":"欲鬼","thumb":"http://csimg.dm300.com/images/spider/20150513/14314500028414.jpg","comicId":"30438","authorName":"色原みたび","comicType":"武侠格斗,魔幻,恐怖","lastCharpter":{"id":"2004710","title":"152电力系统"}},{"title":"反乌托邦公职","thumb":"http://csimg.dm300.com/images/spider/20150324/14271871807842.jpg","comicId":"13256","authorName":"千贺史贵,テルミソ","comicType":"冒险","lastCharpter":{"id":"2007519","title":"第32话"}}]
     */

    @SerializedName("status")
    private int status;
    /**
     * title : 普通的恋子酱
     * thumb : http://csimg.dm300.com/images/spider/20160408/14600893388991.jpg
     * comicId : 50671
     * authorName : 七路眺(ななじ眺)
     * comicType : 爱情,搞笑,校园
     * lastCharpter : {"id":"2007555","title":"普通的恋子酱 009集"}
     */

    @SerializedName("data")
    private List<GridDataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GridDataBean> getData() {
        return data;
    }

    public void setData(List<GridDataBean> data) {
        this.data = data;
    }


}
