/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Uploads {
    public int id;
    public String account;
    public String name;
    public String race;
    public String route;
    public String startTime;
    public int geared;

    public Uploads(int id, String account, String name, String race, String route, String startTime,int geared) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.race = race;
        this.route = route;
        this.startTime = startTime;
        this.geared = geared;
    }

    public Uploads(String account, String name, String race, String route) {
        this.account = account;
        this.name = name;
        this.race = race;
        this.route = route;
    }

    public Uploads() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getGeared() {
        return geared;
    }

    public void setGeared(int geared) {
        this.geared = geared;
    }

    @Override
    public String toString() {
        return "Uploads{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", route='" + route + '\'' +
                ", startTime='" + startTime + '\'' +
                ", geared=" + geared +
                '}';
    }
}
