/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Socket {
    private int id;
    private String combination;
    private String name;
    private String account;
    private String cover;
    private String coverName;
    private String content;
    private int situation;
    private String startTime;
    private int count;

    public String getCombination() {
        return combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Socket{" +
                "id=" + id +
                ", combination='" + combination + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", cover='" + cover + '\'' +
                ", coverName='" + coverName + '\'' +
                ", content='" + content + '\'' +
                ", situation=" + situation +
                ", startTime='" + startTime + '\'' +
                ", count=" + count +
                '}';
    }

    public Socket(int id, String combination, String name, String account, String cover, String coverName, int situation, String startTime, int count, String content) {
        this.id = id;
        this.combination = combination;
        this.name = name;
        this.account = account;
        this.cover = cover;
        this.content = content;
        this.coverName = coverName;
        this.situation = situation;
        this.startTime = startTime;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Socket() {
    }
}
