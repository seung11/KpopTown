package com.album.vo;

public class MemberVO {

	private String userid;
	private String userPass;
	private String userName;	
	private String userPhone;
	private String userEmail;
	private String userZipe; // 우편번호 
	private String userAddr;
	private String userAddr2;
	private String extraAddr;
	private int userPoint;
	private String regdate;
	private int grade; // 회원등급 , 9등급은 관리자
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userPass=" + userPass + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", userZipe=" + userZipe + ", userAddr=" + userAddr
				+ ", userAddr2=" + userAddr2 + ", extraAddr=" + extraAddr + ", userPoint=" + userPoint + ", regdate="
				+ regdate + ", grade=" + grade + "]";
	}
	
	
	
	
	
}
