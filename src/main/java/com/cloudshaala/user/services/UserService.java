package com.cloudshaala.user.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.cloudshaala.beans.RESTServiceResponse;
import com.cloudshaala.beans.Role;
import com.cloudshaala.beans.User;
import com.cloudshaala.user.bean.LoginRequestBean;
@Service
public class UserService {
	
	public RESTServiceResponse isAuthenticated(LoginRequestBean loginRequestBean)
	{
		RESTServiceResponse response=new RESTServiceResponse();
		response.setResult(true);
		response.setMessage("welcome to Cloudshaala");
		
		
		User user=new User("amit", "sharma", "9669561234","abc@gmail.com");		
		user.setUserId("testt5d110345id1");
		
		ArrayList <Role>userRoles =new ArrayList<Role>();
		Role role1=new Role("Teacher", 1,true);
		Role role2=new Role("Parent", 3,true);
		userRoles.add(role1);
		userRoles.add(role2);
		
		HashMap<String , Object> dataMap=new HashMap<>();		
		dataMap.put("user", user);
		dataMap.put("roles", userRoles);
		
		response.setData(dataMap);
		return response;
	}
	
	

}
