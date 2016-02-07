package com.cloudshaala.user.bean;

public class LoginResponseBean {

	private boolean authenticate;

	private String key;

	public boolean isAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
