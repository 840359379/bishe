/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.model;

public class Invitation {
	private int number;
	private String account;
	private String time;
	private String title;
	private String subtitle;
	private String text;
	private String name;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Invitation(int number, String account, String time, String title, String subtitle, String text,
                      String name) {
		super();
		this.number = number;
		this.account = account;
		this.time = time;
		this.title = title;
		this.subtitle = subtitle;
		this.text = text;
		this.name = name;
	}
	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Invitation [number=" + number + ", account=" + account + ", time=" + time + ", title=" + title
				+ ", subtitle=" + subtitle + ", text=" + text + ", name=" + name + "]";
	}
	
	
}
