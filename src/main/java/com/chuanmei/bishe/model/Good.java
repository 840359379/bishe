/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Good {
	private int number;
	private String account;
	private int situation;
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
	public Good(int number, String account,int situation) {
		super();
		this.number = number;
		this.account = account;
		this.situation = situation;
	}
	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}

	@Override
	public String toString() {
		return "Good{" +
				"number=" + number +
				", account='" + account + '\'' +
				", situation=" + situation +
				'}';
	}
}
