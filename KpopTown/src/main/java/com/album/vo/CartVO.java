package com.album.vo;

import java.util.Date;

public class CartVO {

	/*cartnum int auto_increment,
	  userid varchar(50),
	  goodsnumber int,
	  cartStock int,
	  addDate timestamp default now(),
	  primary key(cartnum,userid) 
     */
	
	private int cartNum;  // 장바구니 번호 
	private String userid; // 유저 아이디 
	private int goodsNumber; // 상품번호 
	private int cartStock; // 수량 
	private Date addDate; // 장바구니 추가한 날짜 
	
	
	//join vo
	private int num;
	private String goodsName;
	private int dcPrice;
	private String Img;
	private int Point;
	private String releaseDate;
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
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
	public int getPoint() {
		return Point;
	}
	public void setPoint(int point) {
		Point = point;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", userid=" + userid + ", goodsNumber=" + goodsNumber + ", cartStock="
				+ cartStock + ", addDate=" + addDate + ", num=" + num + ", goodsName=" + goodsName + ", dcPrice="
				+ dcPrice + ", Img=" + Img + ", Point=" + Point + ", releaseDate=" + releaseDate + "]";
	}

}
