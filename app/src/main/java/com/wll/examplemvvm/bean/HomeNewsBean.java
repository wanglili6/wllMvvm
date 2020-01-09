package com.wll.examplemvvm.bean;

import java.util.List;

public class HomeNewsBean {

    /**
     * curPage : 1
     * datas : [{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":11378,"link":"https://weilu.blog.csdn.net/article/details/103823259","niceDate":"6小时前","niceShareDate":"6小时前","origin":"","prefix":"","projectLink":"","publishTime":1578295912000,"selfVisible":0,"shareDate":1578295912000,"shareUser":"唯鹿","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"说说Flutter中的Semantics","type":0,"userId":2657,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":92,"chapterName":"属性动画","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":11369,"link":"https://juejin.im/post/5e1087f9f265da5d75243278","niceDate":"21小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1578242209000,"selfVisible":0,"shareDate":1578242153000,"shareUser":"鸿洋","superChapterId":91,"superChapterName":"动画效果","tags":[],"title":"小菜鸟打怪系列之属性动画绘制原理","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":320,"chapterName":"内存管理","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":11370,"link":"https://juejin.im/post/5e0967fc6fb9a016253c20e0","niceDate":"21小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1578242188000,"selfVisible":0,"shareDate":1578242155000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"Java/Android中的引用类型及WeakReference应用实践","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":11371,"link":"https://juejin.im/post/5e117bbbe51d45410d27e588","niceDate":"21小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1578242171000,"selfVisible":0,"shareDate":1578242157000,"shareUser":"鸿洋","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"JVM 之 内存分配与回收策略","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":233,"chapterName":"四大组件","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11333,"link":"https://juejin.im/post/5e0ca9ccf265da5d4170e844#heading-14","niceDate":"2020-01-03 00:30","niceShareDate":"2020-01-03 00:26","origin":"","prefix":"","projectLink":"","publishTime":1577982628000,"selfVisible":0,"shareDate":1577982394000,"shareUser":"鸿洋","superChapterId":153,"superChapterName":"framework","tags":[],"title":"聊聊 Android 的 GUI 系统","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11346,"link":"https://mp.weixin.qq.com/s/KUiqKFdzyPC_YUwl969X5Q","niceDate":"2020-01-03 00:00","niceShareDate":"2020-01-03 18:57","origin":"","prefix":"","projectLink":"","publishTime":1577980800000,"selfVisible":0,"shareDate":1578049056000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"SharedPreferences存储apply()和commit()的区别你知道吗？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11351,"link":"https://mp.weixin.qq.com/s/jQr6ost3clLGqpHAyNc91Q","niceDate":"2020-01-03 00:00","niceShareDate":"2020-01-03 18:59","origin":"","prefix":"","projectLink":"","publishTime":1577980800000,"selfVisible":0,"shareDate":1578049176000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"从 App 启动过程看 Android 10.0 Framework 重构","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11326,"link":"https://mp.weixin.qq.com/s/g1eA1QLDq8x6-PddQ-sx8A","niceDate":"2020-01-02 09:06","niceShareDate":"2020-01-02 09:06","origin":"","prefix":"","projectLink":"","publishTime":1577927178000,"selfVisible":0,"shareDate":1577927178000,"shareUser":"GSY","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"六年码农生涯的 2019 总结：君子坐而论道，少年起而行之","type":0,"userId":4686,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11344,"link":"https://mp.weixin.qq.com/s/OhdiU4B6KlIwRBC6L1pYJw","niceDate":"2020-01-02 00:00","niceShareDate":"2020-01-03 18:56","origin":"","prefix":"","projectLink":"","publishTime":1577894400000,"selfVisible":0,"shareDate":1578048974000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"&ldquo;我会不会站在原地呢？&rdquo; 2019年终总结","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11345,"link":"https://mp.weixin.qq.com/s/vFugmyzNrIL7dbcpa2vaZA","niceDate":"2020-01-02 00:00","niceShareDate":"2020-01-03 18:57","origin":"","prefix":"","projectLink":"","publishTime":1577894400000,"selfVisible":0,"shareDate":1578049035000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"新年首篇，探究Picasso框架里的那些小秘密！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11349,"link":"https://mp.weixin.qq.com/s/18kwZsmdaE5m6CveSGQQlA","niceDate":"2020-01-02 00:00","niceShareDate":"2020-01-03 18:59","origin":"","prefix":"","projectLink":"","publishTime":1577894400000,"selfVisible":0,"shareDate":1578049142000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"动态代理原理及在 Android 中的应用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11350,"link":"https://mp.weixin.qq.com/s/KiRV2JZylAAJAYhnJGakxA","niceDate":"2020-01-02 00:00","niceShareDate":"2020-01-03 18:59","origin":"","prefix":"","projectLink":"","publishTime":1577894400000,"selfVisible":0,"shareDate":1578049159000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"整理出来几个比较实用的代码对比工具","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11316,"link":"https://blog.csdn.net/Rain_9155/article/details/103792775","niceDate":"2020-01-01 23:33","niceShareDate":"2020-01-01 14:41","origin":"","prefix":"","projectLink":"","publishTime":1577892783000,"selfVisible":0,"shareDate":1577860919000,"shareUser":"rain9155","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"使用贝塞尔曲线实现一个loading控件","type":0,"userId":12884,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11317,"link":"https://www.jianshu.com/p/b7cef3b3e703","niceDate":"2020-01-01 22:35","niceShareDate":"2020-01-01 16:32","origin":"","prefix":"","projectLink":"","publishTime":1577889358000,"selfVisible":0,"shareDate":1577867554000,"shareUser":"鸿洋","superChapterId":134,"superChapterName":"自定义控件","tags":[],"title":"原来Android触控机制竟是这样的？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":185,"chapterName":"组件化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11320,"link":"https://juejin.im/post/5e06e86c6fb9a016526ece70","niceDate":"2020-01-01 22:35","niceShareDate":"2020-01-01 22:33","origin":"","prefix":"","projectLink":"","publishTime":1577889340000,"selfVisible":0,"shareDate":1577889212000,"shareUser":"鸿洋","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android组件化跨进程通信框架Andromeda解析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":31,"chapterName":"Dialog","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11321,"link":"https://www.jianshu.com/p/9857c45737de","niceDate":"2020-01-01 22:35","niceShareDate":"2020-01-01 22:33","origin":"","prefix":"","projectLink":"","publishTime":1577889324000,"selfVisible":0,"shareDate":1577889239000,"shareUser":"鸿洋","superChapterId":30,"superChapterName":"用户交互","tags":[],"title":"为什么Dialog弹出以后，activity就无法捕捉触摸事件了？","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11343,"link":"https://mp.weixin.qq.com/s/jK-r_GpiYXDISkUcZuWgMw","niceDate":"2020-01-01 00:00","niceShareDate":"2020-01-03 18:55","origin":"","prefix":"","projectLink":"","publishTime":1577808000000,"selfVisible":0,"shareDate":1578048955000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"发现一个超强Android 进阶路线知识图谱","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":232,"chapterName":"入门及知识点","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11293,"link":"https://juejin.im/entry/5e077da3518825127869af64","niceDate":"2019-12-31 00:41","niceShareDate":"2019-12-30 08:33","origin":"","prefix":"","projectLink":"","publishTime":1577724106000,"selfVisible":0,"shareDate":1577666004000,"shareUser":"goweii","superChapterId":232,"superChapterName":"Kotlin","tags":[],"title":"拥抱kotlin:利用kotlin实现单例模式","type":0,"userId":20382,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11294,"link":"https://juejin.im/post/5e08ac516fb9a0164c7bbc9d","niceDate":"2019-12-31 00:41","niceShareDate":"2019-12-30 09:29","origin":"","prefix":"","projectLink":"","publishTime":1577724087000,"selfVisible":0,"shareDate":1577669371000,"shareUser":"JsonChao","superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"我的2019年终总结","type":0,"userId":611,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":11295,"link":"https://jsonchao.github.io/2019/12/29/%E6%B7%B1%E5%85%A5%E6%8E%A2%E7%B4%A2Android%E5%86%85%E5%AD%98%E4%BC%98%E5%8C%96/","niceDate":"2019-12-31 00:40","niceShareDate":"2019-12-30 09:50","origin":"","prefix":"","projectLink":"","publishTime":1577724058000,"selfVisible":0,"shareDate":1577670649000,"shareUser":"JsonChao","superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"深入探索Android内存优化","type":0,"userId":611,"visible":1,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 391
     * size : 20
     * total : 7815
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * apkLink :
         * audit : 1
         * author :
         * chapterId : 502
         * chapterName : 自助
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : true
         * id : 11378
         * link : https://weilu.blog.csdn.net/article/details/103823259
         * niceDate : 6小时前
         * niceShareDate : 6小时前
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1578295912000
         * selfVisible : 0
         * shareDate : 1578295912000
         * shareUser : 唯鹿
         * superChapterId : 494
         * superChapterName : 广场Tab
         * tags : []
         * title : 说说Flutter中的Semantics
         * type : 0
         * userId : 2657
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private int audit;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String niceShareDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private long publishTime;
        private int selfVisible;
        private long shareDate;
        private String shareUser;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<?> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getNiceShareDate() {
            return niceShareDate;
        }

        public void setNiceShareDate(String niceShareDate) {
            this.niceShareDate = niceShareDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSelfVisible() {
            return selfVisible;
        }

        public void setSelfVisible(int selfVisible) {
            this.selfVisible = selfVisible;
        }

        public long getShareDate() {
            return shareDate;
        }

        public void setShareDate(long shareDate) {
            this.shareDate = shareDate;
        }

        public String getShareUser() {
            return shareUser;
        }

        public void setShareUser(String shareUser) {
            this.shareUser = shareUser;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}
