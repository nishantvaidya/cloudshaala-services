package com.cloudshaala.user.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudshaala.user.bean.LoginRequestBean;
import com.cloudshaala.user.bean.LoginResponseBean;
import com.cloudshaala.user.bean.Roles;
import com.cloudshaala.user.bean.UserBean;
@Service
public class UserService {
	
	public LoginResponseBean isAuthenticated(LoginRequestBean loginRequestBean)
	{
		LoginResponseBean lresb=new LoginResponseBean();
		lresb.setAuthenticate(true);  
		return lresb;	
	}
	
	
	public UserBean getUserDetails(){
		List <Roles>userRoles =new ArrayList();
		
		Roles role1=new Roles();
		role1.setRoleId(1);
		role1.setRoleTitle("Parent");
		role1.setIsActive(true);
		
		Roles role2=new Roles();
		role2.setRoleId(2);
		role2.setRoleTitle("Teacher");
		role2.setIsActive(true);
		userRoles.add(role1);
		userRoles.add(role2);
		
		UserBean user=new UserBean();
		user.setFirstName("testuser");
		user.setUserId("testid1");
		user.setRoles(userRoles);
		
		return user;
	}

}
