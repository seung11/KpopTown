package com.album.vo;

public class PageVO {
	
	
	private CriteriaVO cri;
	//시작페이지
	private int startPage;
	//끝페이지
	private int endPage;
	//이전페이지 다음페이지
	private boolean next , prev;
	//게시물 총 갯수 
	private int total;
	private int displayPageNum = 5; // 화면에 보여지는 페이지 버튼의 수 
	public CriteriaVO getCri() {
		return cri;
	}
	public void setCri(CriteriaVO cri) {
		this.cri = cri;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		calcData();  //calcData 메서드를 호출
	}
	
	private void calcData() {  // 페이징 관련 버튼 계산
		
		// 끝 페이지 = (현재 페이지 번호/화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		endPage = (int)(Math.ceil(cri.getPage()/ (double) displayPageNum) * displayPageNum);
		
		// 시작 페이지 번호 = (끝페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
		startPage = (endPage - displayPageNum) + 1;
		if (startPage <= 0) startPage = 1;
		
		// 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글 수 
		int tempEndPage = (int)(Math.ceil(total/(double) cri.getAmount()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// 버튼 생성 여부 = 시작 페이지 번호가 1이 아니면 생기게 된다.
		prev = startPage == 1 ? false:true;
		// 끝 페이지 번호 * 한페이지당 보여줄 게시글의 갯수 < 총 게시글의 수
		next = endPage* cri.getAmount() <total ? true : false;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	

	@Override
	public String toString() {
		return "PageVO [cri=" + cri + ", startPage=" + startPage + ", endPage=" + endPage + ", next=" + next + ", prev="
				+ prev + ", total=" + total + ", displayPageNum=" + displayPageNum + "]";
	}
	
	
	
	

	
	
	
	
}
