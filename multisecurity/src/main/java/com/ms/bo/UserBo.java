package com.ms.bo;

public class UserBo {

	protected int userNo;
	protected String userName;
	protected String password;
	protected RoleBo bo;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public RoleBo getBo() {
		return bo;
	}
	public void setBo(RoleBo bo) {
		this.bo = bo;
	}
	@Override
	public String toString() {
		return "UserBo [userNo=" + userNo + ", userName=" + userName + ", bo=" + bo + "]";
	}
	
	
}
