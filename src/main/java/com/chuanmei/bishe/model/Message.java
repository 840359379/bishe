/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Message {
    private int id;
    private String account;
    private String name;
    private String coverAccount;
    private String startTime;
    private String substance;

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

    public String getCoverAccount() {
        return coverAccount;
    }

    public void setCoverAccount(String coverAccount) {
        this.coverAccount = coverAccount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Message() {
    }

    public Message(int id, String account, String name, String coverAccount, String startTime, String substance) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.coverAccount = coverAccount;
        this.startTime = startTime;
        this.substance = substance;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", coverAccount='" + coverAccount + '\'' +
                ", startTime='" + startTime + '\'' +
                ", substance='" + substance + '\'' +
                '}';
    }
}
