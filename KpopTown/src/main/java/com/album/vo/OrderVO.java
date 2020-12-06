package com.album.vo;

import java.util.Date;

public class OrderVO {

	/*	
	orderid varchar(50),
    userid varchar(50),
    orderRec varchar(50),
    userzipe varchar(20),
    useraddr varchar(100),
    useraddr2 varchar(50),
    orderPhone varchar(50),
    amount int,
    orderDate timestamp default now(),
    
    */
	
	
	private String orderId;
	private String userid;
	private String orderRec;
	private String orderPhone;
	private String userZipe;
	private String userAddr;
	private String userAddr2;
	private String extraAddr;
	private int Amount;
	private Date orderDate;
	private String Delivery;
	private int Point;
	
	// 포인트 넣어주기 위해서 MemberVO클래스를 변수선언함
	private MemberVO mvo;

	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrderRec() {
		return orderRec;
	}

	public void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getUserZipe() {
		return userZipe;
	}

	public void setUserZipe(String userZipe) {
		this.userZipe = userZipe;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getExtraAddr() {
		return extraAddr;
	}

	public void setExtraAddr(String extraAddr) {
		this.extraAddr = extraAddr;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public String getDelivery() {
		return Delivery;
	}

	public void setDelivery(String delivery) {
		Delivery = delivery;
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public MemberVO getMvo() {
		return mvo;
	}

	public void setMvo(MemberVO mvo) {
		this.mvo = mvo;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", userid=" + userid + ", orderRec=" + orderRec + ", orderPhone="
				+ orderPhone + ", userZipe=" + userZipe + ", userAddr=" + userAddr + ", userAddr2=" + userAddr2
				+ ", extraAddr=" + extraAddr + ", Amount=" + Amount + ", orderDate=" + orderDate + ", Delivery="
				+ Delivery + ", Point=" + Point + ", mvo=" + mvo + "]";
	}

}
