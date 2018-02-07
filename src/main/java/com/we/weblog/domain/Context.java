package com.we.weblog.domain;


import java.util.Date;


public class Context {
    //   博客内容md 博客内容的html


    // 博客id
    private int   uid;
    //创建时间
    private Date   created;
    //博客名称
    private String   title;
    //博客标签
    private String   tags;
   //文章标签
    public String  article;
    //md内容
    private String  md;
    //发布时间
    private String month;
    //文章类型
    private String type;
    //缩略名
    private String slug;



    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMdText() {
        return md;
    }

    public void setMdText(String md) {
        this.md = md;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }



}