package com.cloudshaala.user.bean;

public class Roles {
	
	private int roleId;
	private String roleTitle;
	private Boolean isActive ;
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleTitle
	 */
	public String getRoleTitle() {
		return roleTitle;
	}
	/**
	 * @param roleTitle the roleTitle to set
	 */
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleTitle=" + roleTitle + ", isActive=" + isActive + "]";
	}
	
	

}
