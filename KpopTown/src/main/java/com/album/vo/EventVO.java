package com.album.vo;

import java.util.Date;

public class EventVO {
	
	/*
	evNumber int auto_increment,
 	evTitle varchar(100) not null,
 	evCon varchar(6000) not null,
 	regdate timestamp default now(),
	 *
	 */
	
	private int evNumber;
	private String evTitle;
	private String evCon;
	private String evImg;
	private Date regdate;
	
	
	public String getEvImg() {
		return evImg;
	}
	public void setEvImg(String evImg) {
		this.evImg = evImg;
	}
	public int getEvNumber() {
		return evNumber;
	}
	public void setEvNumber(int evNumber) {
		this.evNumber = evNumber;
	}
	public String getEvTitle() {
		return evTitle;
	}
	public void setEvTitle(String evTitle) {
		this.evTitle = evTitle;
	}
	public String getEvCon() {
		return evCon;
	}
	public void setEvCon(String evCon) {
		this.evCon = evCon;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "EventVO [evNumber=" + evNumber + ", evTitle=" + evTitle + ", evCon=" + evCon + ", evImg=" + evImg
				+ ", regdate=" + regdate + "]";
	}
	
	

}
