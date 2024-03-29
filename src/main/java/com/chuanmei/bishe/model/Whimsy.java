/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

import java.util.List;

public class Whimsy {
    private int id;
    private int series;
    private String account;
    private String title;
    private String subtitle;
    private String route;
    private String behind;
    private String startTime;
    private Integer obtain;
    private List<Uploads> list;

    public List<Uploads> getList() {
        return list;
    }

    public void setList(List<Uploads> list) {
        this.list = list;
    }

    public Whimsy(int id, int series, String account, String title, String subtitle, String route, String behind, String startTime,int obtain) {
        this.id = id;
        this.series = series;
        this.account = account;
        this.title = title;
        this.subtitle = subtitle;
        this.route = route;
        this.behind = behind;
        this.startTime = startTime;
        this.obtain = obtain;
    }

    public Whimsy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getBehind() {
        return behind;
    }

    public void setBehind(String behind) {
        this.behind = behind;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getObtain() {
        return obtain;
    }

    public void setObtain(Integer obtain) {
        this.obtain = obtain;
    }

    @Override
    public String toString() {
        return "Whimsy{" +
                "id=" + id +
                ", series=" + series +
                ", account='" + account + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", route='" + route + '\'' +
                ", behind='" + behind + '\'' +
                ", startTime='" + startTime + '\'' +
                ", obtain=" + obtain +
                ", list=" + list +
                '}';
    }
}
