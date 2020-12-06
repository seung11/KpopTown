package com.album.vo;

public class CategoryVO {
	
	/*
	  cateName varchar(50) not null,
	  cateCode varchar(50) not null,
	*/
	

	private String cateName;
	private String cateCode;

	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	@Override
	public String toString() {
		return "CategoryVO [ cateName=" + cateName + ", cateCode=" + cateCode + "]";
	}
	
	
	
}
