package com.kh.java.member.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Member {
	// int vs long = long이 우세하다 이유 : long이 표현 할 수 있는 범위 가 더 넓다 
	//long vs Long = Long이 우세하다  이유 : 프레임 워크 호환성 때문에 
	 private Long userNo;
	 private String userId;
	 private String userPwd;
	 private String userName; 
	 private String email;
	 private Date enrollDate;
	 private Date modiOfyDate;
	 private String status;
	 
	public Member() {
		super();
	}
	public Member(Long userNo, String userId, String userPwd, String userName, String email, Date enrollDate,
			Date modiOfyDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.modiOfyDate = modiOfyDate;
		this.status = status;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getModiOfyDate() {
		return modiOfyDate;
	}
	public void setModiOfyDate(Date modiOfyDate) {
		this.modiOfyDate = modiOfyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", Email=" + email + ", EnrollDate=" + enrollDate + ", modiOfyDate=" + modiOfyDate + ", status="
				+ status + "]";
	}
	
	
	 
	

}
