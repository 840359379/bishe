/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Collection {
    private int number;
    private String account;
    private int content;
    private int good;
    private String title;
    private String subtitle;
    private int situation;
    public Collection() {
    }

    @Override
    public String toString() {
        return "Collection{" +
                "number=" + number +
                ", account='" + account + '\'' +
                ", content=" + content +
                ", good=" + good +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", situation='" + situation + '\'' +
                '}';
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Collection(int number, String account, int content, int good, String title, String subtitle,int situation) {
        this.number = number;
        this.account = account;
        this.content = content;
        this.good = good;
        this.title = title;
        this.subtitle = subtitle;
        this.situation = situation;
    }
}
