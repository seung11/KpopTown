package com.album.vo;

import java.util.Date;

public class productVO {

	
	private int goodsNumber;
	private String cateCode;
	private String goodsName;
	private int Stock;
	private int origPrice;
	private int Dc;
	private int dcPrice;
	private int Point;
	private String releaseDate;
	private String Company;
	private String goodsDetail;
	private String img;
	private String ThumbImg;
	private Date regDate;
	private int sellCount;
	
	//페이징
	private CriteriaVO cri;
	// 카테고리
	private String CateName;
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public int getOrigPrice() {
		return origPrice;
	}
	public void setOrigPrice(int origPrice) {
		this.origPrice = origPrice;
	}
	public int getDc() {
		return Dc;
	}
	public void setDc(int dc) {
		Dc = dc;
	}
	public int getDcPrice() {
		return dcPrice;
	}
	public void setDcPrice(int dcPrice) {
		this.dcPrice = dcPrice;
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
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getThumbImg() {
		return ThumbImg;
	}
	public void setThumbImg(String thumbImg) {
		ThumbImg = thumbImg;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public CriteriaVO getCri() {
		return cri;
	}
	public void setCri(CriteriaVO cri) {
		this.cri = cri;
	}
	public String getCateName() {
		return CateName;
	}
	public void setCateName(String cateName) {
		CateName = cateName;
	}
	@Override
	public String toString() {
		return "productVO [goodsNumber=" + goodsNumber + ", cateCode=" + cateCode + ", goodsName=" + goodsName
				+ ", Stock=" + Stock + ", origPrice=" + origPrice + ", Dc=" + Dc + ", dcPrice=" + dcPrice + ", Point="
				+ Point + ", releaseDate=" + releaseDate + ", Company=" + Company + ", goodsDetail=" + goodsDetail
				+ ", img=" + img + ", ThumbImg=" + ThumbImg + ", regDate=" + regDate + ", sellCount=" + sellCount
				+ ", cri=" + cri + ", CateName=" + CateName + "]";
	}
	
	
	
	
	
	
}
