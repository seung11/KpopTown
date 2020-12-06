package com.album.vo;

import java.util.Date;

public class OrderListVO {
	
	// tbl_product
	private String goodsName;
	private int dcPrice;
	private String Img;
	
	// tbl_OrderVO
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

	
	
	// order_detail
	private int orderDetailNum;
	private int goodsNumber;
	private int cartStock;
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getDcPrice() {
		return dcPrice;
	}
	public void setDcPrice(int dcPrice) {
		this.dcPrice = dcPrice;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	
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
	public int getOrderDetailNum() {
		return orderDetailNum;
	}
	public void setOrderDetailNum(int orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	@Override
	public String toString() {
		return "OrderListVO [goodsName=" + goodsName + ", dcPrice=" + dcPrice + ", Img=" + Img + ", orderId=" + orderId
				+ ", userid=" + userid + ", orderRec=" + orderRec + ", orderPhone=" + orderPhone + ", userZipe="
				+ userZipe + ", userAddr=" + userAddr + ", userAddr2=" + userAddr2 + ", extraAddr=" + extraAddr
				+ ", Amount=" + Amount + ", orderDate=" + orderDate + ", Delivery=" + Delivery + ", orderDetailNum="
				+ orderDetailNum + ", goodsNumber=" + goodsNumber + ", cartStock=" + cartStock + "]";
	}
	
}
