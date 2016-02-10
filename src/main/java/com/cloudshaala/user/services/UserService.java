package com.cloudshaala.user.services;

import org.springframework.stereotype.Service;

import com.cloudshaala.user.bean.LoginResponseBean;
@Service
public class UserService {
	
	public LoginResponseBean isAuthenticated()
	{
		LoginResponseBean lresb=new LoginResponseBean();
		lresb.setAuthenticate(true);
		return lresb;	 	
	}

}
