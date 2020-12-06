package com.album.vo;

import java.util.Date;

public class ReviewVO {
	
	// 상품 후기 
	
	/*
	goodsnumber int not null,
	userid varchar(50) not null,
	rwNumber int auto_increment not null,
	rwTitle varchar(100) not null.
	rwCon varchar(3000) not null,
	rwData timestamp default now(),
	 */
	
	private int goodsNumber;
	private String userid;
	private int rwNumber;
	private String rwTitle;
	private String rwCon;
	private Date rwDate;
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getRwNumber() {
		return rwNumber;
	}
	public void setRwNumber(int rwNumber) {
		this.rwNumber = rwNumber;
	}
	public String getRwTitle() {
		return rwTitle;
	}
	public void setRwTitle(String rwTitle) {
		this.rwTitle = rwTitle;
	}
	public String getRwCon() {
		return rwCon;
	}
	public void setRwCon(String rwCon) {
		this.rwCon = rwCon;
	}
	public Date getRwDate() {
		return rwDate;
	}
	public void setRwDate(Date rwDate) {
		this.rwDate = rwDate;
	}
	@Override
	public String toString() {
		return "ReviewVO [goodsNumber=" + goodsNumber + ", userid=" + userid + ", rwNumber=" + rwNumber + ", rwTitle="
				+ rwTitle + ", rwCon=" + rwCon + ", rwDate=" + rwDate + "]";
	}
	

}
