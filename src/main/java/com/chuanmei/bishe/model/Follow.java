/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Follow {
	private String account;
	private String coveraccount;
	private String name;
	private String covername;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCoveraccount() {
		return coveraccount;
	}
	public void setCoveraccount(String coveraccount) {
		this.coveraccount = coveraccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCovername() {
		return covername;
	}
	public void setCovername(String covername) {
		this.covername = covername;
	}
	@Override
	public String toString() {
		return "Follow [account=" + account + ", coveraccount=" + coveraccount + ", name=" + name + ", covername="
				+ covername + "]";
	}

	public Follow(String account, String coveraccount, String name, String covername) {
		this.account = account;
		this.coveraccount = coveraccount;
		this.name = name;
		this.covername = covername;
	}
}
