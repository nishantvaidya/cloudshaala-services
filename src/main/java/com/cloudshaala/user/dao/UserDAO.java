package com.cloudshaala.user.dao;

import java.sql.Connection;

import com.cloudshaala.beans.main.UserBean;
import com.cloudshaala.beans.rest.request.RegistrationBean;
import com.cloudshaala.utils.Database;

public class UserDAO {
	public UserBean userRegistration(RegistrationBean registration)
	{
		UserBean user=new UserBean();
		
		Connection con=Database.openConnection();
		String query="insert into user userId, firstname,lastname,email,mobile values(?,?,?,?)";
		return user;
		
	}
}
