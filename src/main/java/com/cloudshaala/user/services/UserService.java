package com.cloudshaala.user.services;

import com.cloudshaala.user.bean.LoginResponseBean;

public class UserService {
	
	public LoginResponseBean isAuthenticated()
	{
		LoginResponseBean lresb=new LoginResponseBean();
		lresb.setAuthenticate(true);
		return lresb;		
	}

}
