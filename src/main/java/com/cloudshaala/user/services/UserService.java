package com.cloudshaala.user.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloudshaala.beans.main.RoleBean;
import com.cloudshaala.beans.main.UserBean;
import com.cloudshaala.beans.rest.request.LoginBean;
import com.cloudshaala.beans.rest.request.RegistrationBean;
import com.cloudshaala.beans.rest.response.RESTServiceResponseBean;
@Service
public class UserService {
	
	public RESTServiceResponseBean isAuthenticated(LoginBean loginBean)
	{
		RESTServiceResponseBean response=new RESTServiceResponseBean();
		response.setResult(true);
		response.setMessage("welcome to Cloudshaala");
		
		UserBean user=new UserBean("amit", "sharma", "9669561234","abc@gmail.com");		
		user.setUserId("testt5d110345id1");
		
		ArrayList <RoleBean>userRoles =new ArrayList<RoleBean>();
		RoleBean role1=new RoleBean("Teacher", 1,true);
		RoleBean role2=new RoleBean("Parent", 3,true);
		userRoles.add(role1);
		userRoles.add(role2);
		
		HashMap<String , Object> dataMap=new HashMap<>();		
		dataMap.put("user", user);
		dataMap.put("roles", userRoles);
		
		response.setData(dataMap);
		return response;
	}
	
	public RESTServiceResponseBean registration(RegistrationBean registration)
	{
		RESTServiceResponseBean response=new RESTServiceResponseBean();
		response.setResult(true);
		response.setMessage("welcome to Cloudshaala. your password is sent to your mobile and email.");
		//new user id created
		UserBean user=new UserBean("amit", "sharma", "9669561234","abc@gmail.com");
		user.setUserId("testt5d110345id1");
		
		ArrayList <RoleBean>userRoles =new ArrayList<RoleBean>();
		RoleBean newRole=new RoleBean("Teacher", 1,true);
		userRoles.add(newRole);
		
		HashMap<String , Object> dataMap=new HashMap<>();		
		dataMap.put("user", user);
		dataMap.put("roles", userRoles);
		response.setData(dataMap);
		return response;
	}
	 public RESTServiceResponseBean isEmailExist (String emailId )
	 {
		 	RESTServiceResponseBean response=new RESTServiceResponseBean();
			response.setResult(true);
			response.setMessage("email address abc@gmail.com is already registered. "
					+ "if it's your email, then go to recover password option");
			//new user id created
			UserBean user=new UserBean("amit", "sharma", "9669561234","abc@gmail.com");
			response.setData(user);
			
	        return response;
	   }
	 public RESTServiceResponseBean isMobileExist (String mobile )
	 {
		 	RESTServiceResponseBean response=new RESTServiceResponseBean();
			response.setResult(true);
			response.setMessage("mobile 9669561234 is already registered. "
					+ "if it's your mobie, then go to recover password option");
			//new user id created
			UserBean user=new UserBean("amit", "sharma", "9669561234","abc@gmail.com");
			response.setData(user);
			
	        return response;
	   }
}
