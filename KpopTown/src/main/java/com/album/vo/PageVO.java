package com.album.vo;

public class PageVO {
	
	
	private CriteriaVO cri;
	//����������
	private int startPage;
	//��������
	private int endPage;
	//���������� ����������
	private boolean next , prev;
	//�Խù� �� ���� 
	private int total;
	private int displayPageNum = 5; // ȭ�鿡 �������� ������ ��ư�� �� 
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
		calcData();  //calcData �޼��带 ȣ��
	}
	
	private void calcData() {  // ����¡ ���� ��ư ���
		
		// �� ������ = (���� ������ ��ȣ/ȭ�鿡 ������ ������ ��ȣ�� ����) * ȭ�鿡 ������ ������ ��ȣ�� ����
		endPage = (int)(Math.ceil(cri.getPage()/ (double) displayPageNum) * displayPageNum);
		
		// ���� ������ ��ȣ = (�������� ��ȣ - ȭ�鿡 ������ ������ ��ȣ�� ����) + 1
		startPage = (endPage - displayPageNum) + 1;
		if (startPage <= 0) startPage = 1;
		
		// ������ ������ ��ȣ = �� �Խñ� �� / �� �������� ������ �Խñ� �� 
		int tempEndPage = (int)(Math.ceil(total/(double) cri.getAmount()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// ��ư ���� ���� = ���� ������ ��ȣ�� 1�� �ƴϸ� ����� �ȴ�.
		prev = startPage == 1 ? false:true;
		// �� ������ ��ȣ * ���������� ������ �Խñ��� ���� < �� �Խñ��� ��
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
