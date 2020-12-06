package com.album.vo;

public class CriteriaVO {
 
	//����¡ ó�� 
	private int page; // ���� ������ 
	private int amount;  // �������� ����� �Խù� ���� 
	
	public int getPageStart() {  // Ư�� ������ �Խñ� ���� ��ȣ 
		// ���� �������� �Խñ� ���� ��ȣ = (���� ������ ��ȣ - 1) * �������� ������ �Խñ� ��  
		return (this.page-1)*amount; 
	}
	
	// �⺻ ������
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
