package com.album.vo;

public class CriteriaVO {
 
	//페이징 처리 
	private int page; // 현재 페이지 
	private int amount;  // 페이지당 노출될 게시물 갯수 
	
	public int getPageStart() {  // 특정 페이지 게시글 시작 번호 
		// 현재 페이지의 게시글 시작 번호 = (현재 페이지 번호 - 1) * 페이지당 보여줄 게시글 수  
		return (this.page-1)*amount; 
	}
	
	// 기본 생성자
	public CriteriaVO() {
		this.page = 1;
		this.amount = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}else {
			
			this.page = page;
		}
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int pageCount) {
		int cnt = this.amount;
		if (pageCount != cnt) {
			this.amount = cnt;
		}else {
			
			this.amount = pageCount;
		}
	}

	@Override
	public String toString() {
		return "CriteriaVO [page=" + page + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
	
}
