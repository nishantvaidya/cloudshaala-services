package com.cloudshaala.user.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.cloudshaala.beans.main.RoleBean;
import com.cloudshaala.beans.main.UserBean;
import com.cloudshaala.beans.rest.request.LoginBean;
import com.cloudshaala.beans.rest.request.RegistrationBean;
import com.cloudshaala.beans.rest.response.RESTServiceResponseBean;
import com.cloudshaala.user.dao.UserDAO;
@Service
public class UserService {
	UserDAO userDAO;
	public UserService() {
		userDAO=new UserDAO();
	}
	public RESTServiceResponseBean isAuthenticated(LoginBean loginBean)
	{
		RESTServiceResponseBean response=new RESTServiceResponseBean();	
		
		Object data=userDAO.isAuthenticated(loginBean);
		if(data!=null)
		{
			response.setResult(true);
			response.setMessage("welcome to Cloudshaala");	
			response.setData(data);
		}
		else
		{
			response.setResult(false);
			response.setMessage("Invalid login details");	
			response.setData(data);
		}
		return response;
	}
	
	public RESTServiceResponseBean registration(RegistrationBean registration)
	{
		RESTServiceResponseBean response=new RESTServiceResponseBean();
		response=this.isEmailExist(registration.getEmail());
		if(response.getResult().equals(false)) //email not already registered
		{
			response=this.isMobileExist( registration.getMobile() );
			if(response.getResult().equals(false))//mobile not already registered
			{
				
				UserBean user=userDAO.userRegistration(registration);
				if(user!=null)
				{
					response.setResult(true);
					response.setMessage("welcome to Cloudshaala. your password is sent to your mobile and email.");
					//new user id created
					
					ArrayList <RoleBean>userRoles =new ArrayList<RoleBean>();				
					userRoles.add(registration.getRole());
				
					HashMap<String , Object> dataMap=new HashMap<>();		
					dataMap.put("user", user);
					dataMap.put("roles", userRoles);
					response.setData(dataMap);
				}
				else{
					response.setResult(false);
					response.setMessage("something went wrong :( try again");
				}
		    }else
		    {
		    	response.setResult(false);
		    }
		}else
	    {
	    	response.setResult(false);
	    }
		return response;
	}
	 public RESTServiceResponseBean isEmailExist (String emailId )
	 {
		 System.out.println("service:"+emailId);
		 	RESTServiceResponseBean response=new RESTServiceResponseBean();
		 	if(userDAO.isEmailExist(emailId))
			{
				response.setResult(true);
				response.setMessage("email address "+emailId+" is already registered. "
						+ "if it's your email, then go to recover password option");
			}
			else
				response.setResult(false);
	        return response;
	   }
	 public RESTServiceResponseBean isMobileExist (String mobile )
	 {
		 	RESTServiceResponseBean response=new RESTServiceResponseBean();
			if(userDAO.isMobileExist( mobile) )
			{
				response.setResult(true);
				response.setMessage("mobile "+mobile+" is already registered. "
						+ "if it's your mobie, then go to recover password option");
			}
			else
				response.setResult(false);
	        return response;
	   }
}
