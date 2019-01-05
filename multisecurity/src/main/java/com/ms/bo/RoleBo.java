package com.ms.bo;



public class RoleBo {

	protected int roleNo;
	protected String roleName;
	public int getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleBo [roleNo=" + roleNo + ", roleName=" + roleName + "]";
	}
	
	
}
