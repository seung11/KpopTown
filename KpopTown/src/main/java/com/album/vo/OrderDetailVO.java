package com.album.vo;

public class OrderDetailVO {


	private int orderDetailNum;
	private String orderId;
	private int goodsNumber;
	private int cartStock;
	public int getOrderDetailNum() {
		return orderDetailNum;
	}
	public void setOrderDetailNum(int orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
		return "OrderDetailVO [orderDetailNum=" + orderDetailNum + ", orderId=" + orderId + ", goodsNumber="
				+ goodsNumber + ", cartStock=" + cartStock + "]";
	}

	
	
	
	
	
}


