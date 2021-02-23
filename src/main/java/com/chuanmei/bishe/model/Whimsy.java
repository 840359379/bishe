package com.chuanmei.bishe.model;

public class Whimsy {
    private int id;
    private int series;
    private String account;
    private String title;
    private String subtitle;
    private String route;
    private String behind;
    private String startTime;

    public Whimsy(int id, int series, String account, String title, String subtitle, String route, String behind, String startTime) {
        this.id = id;
        this.series = series;
        this.account = account;
        this.title = title;
        this.subtitle = subtitle;
        this.route = route;
        this.behind = behind;
        this.startTime = startTime;
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
                '}';
    }
}
