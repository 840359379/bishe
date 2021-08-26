/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Administrators {
    private int id;
    private String account;
    private String name;

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

    public Administrators(int id, String account, String name) {
        this.id = id;
        this.account = account;
        this.name = name;
    }

    public Administrators() {
    }

    @Override
    public String toString() {
        return "Administrators{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
