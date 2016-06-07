package com.cloudshaala.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.cloudshaala.beans.main.RoleBean;
import com.cloudshaala.beans.main.UserBean;
import com.cloudshaala.beans.rest.request.LoginBean;
import com.cloudshaala.beans.rest.request.RegistrationBean;
import com.cloudshaala.utils.Database;
import com.cloudshaala.utils.IDGenerator;

public class UserDAO {
		
	public UserBean userRegistration(RegistrationBean registration)
	{
		UserBean user=null;
		
		String userId=IDGenerator.getNewId("cuid"); //new us_er id
		String password=IDGenerator.getNewId("pwd"); //new user id
		Connection con=Database.openConnection();
		String query="insert into user (user_id, firstname,lastname,email,mobile,password, registration_platform,primaryInstitutionType)"
				+ " values(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, userId);
			pst.setString(2, registration.getFirstname());
			pst.setString(3, registration.getLastname());
			pst.setString(4, registration.getEmail());
			pst.setString(5, registration.getMobile());
			pst.setString(6, password);
			pst.setString(7, registration.getRegistrationPlatform() );
			pst.setString(8, registration.getPrimaryInstitutionType());
			
			int rows=pst.executeUpdate();
			pst.close();
			if(rows>=1)
			{
				user=new UserBean(registration.getFirstname(), registration.getLastname(), registration.getMobile(), registration.getEmail());
				user.setUserId(userId);
				user.setPassword(password);
				//add a row to user role table 
				query="insert into user_role (user_id, role_id, role_join_date)"
						+ " values(?,?, now())";
				PreparedStatement pst2=con.prepareStatement(query);				
				pst2.setString(1, userId);
				pst2.setInt(2, registration.getRole().getroleId());
				System.out.println("reg query1:"+query);
				pst2.executeUpdate();
				pst2.close();
			
				//create a new id for the role
				query=null;
				String uniqueIdForRole=IDGenerator.getNewId(registration.getRole().getroleId()+"");
				switch (registration.getRole().getroleId()) 
				{
				case 1://teacher
				{					
					query="insert into teacher (user_id, teacher_id, is_active, created_on)"
							+ " values(?,?,? , now())";				
				}
				break;
				case 2://student
				{					
					query="insert into student (user_id, student_id, is_active, created_on)"
							+ " values(?,?,? ,now())";				
				}
				case 3://parent
				{					
					query="insert into parent (user_id, parent_id, is_active, created_on)"
							+ " values(?,?,?, now())";				
				}
				break;
				case 4://institution_admin
				{					
					query="insert into institution (created_by, institution_id, is_active, created_on)"
							+ " values(?,?,?, now() )";				
				}					
			}
				System.out.println("reg query2:"+query);
				if(query!=null)
				{
					PreparedStatement pst3=con.prepareStatement(query);				
					pst3.setString(1, userId);
					pst3.setString(2, uniqueIdForRole);
					pst3.setInt(3, 1);
					pst3.executeUpdate();
					pst3.close();
				
				}
				
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return user;
		
	}
	public Object isAuthenticated (LoginBean loginBean)
	 {
		HashMap<String , Object> dataMap=null;
		boolean result=false;
		String query="select * from user where (email=? or mobile=? or user_id=?) and password=?";
		try{
			Connection con=Database.openConnection();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, loginBean.getUsername());
			pst.setString(2, loginBean.getUsername());
			pst.setString(3, loginBean.getUsername());
			pst.setString(4, loginBean.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
			
				UserBean user=new UserBean(rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("email"),rs.getString("mobile"));	
				
				user.setUserId(rs.getString("user_id"));
				
				//get user roles
				query="select role.role_name,role.role_id, user_role.is_active from  role,user_role where user_role.user_id="+user.getUserId()+" and role.role_id=user_role.role_id";
				PreparedStatement pst2=con.prepareStatement(query);
				//pst2.setString(1, user.getUserId());
				ResultSet rs2=pst2.executeQuery();
				
				ArrayList <RoleBean>userRoles =new ArrayList<RoleBean>();
				while(rs2.next())
				{
					RoleBean role=new RoleBean(rs2.getString("role_name"), rs2.getInt("role_id"),false);
					if(rs2.getInt("is_active")==1)
						role.setActive(true);
					
					userRoles.add(role);
				}
				rs2.close();
				pst2.close();
				
				dataMap=new HashMap<>();
				dataMap.put("user", user);
				dataMap.put("roles", userRoles);
				
			}
			rs.close();
			pst.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dataMap;
	
		
	 }
	public boolean isEmailExist (String emailId )
	 {
		System.out.println("dao"+emailId);
		boolean result=false;
		String query="select * from user where email=?";
		try{
			Connection con=Database.openConnection();
						PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, emailId);
				
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				result=true;
			}
			rs.close();
			pst.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	
		
	 }
	public boolean isMobileExist (String mobile )
	 {
		boolean result=false;
		String query="select * from user where mobile=?";
		try{
			Connection con=Database.openConnection();
						PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, mobile);
				
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				result=true;
			}
			rs.close();
			pst.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	
	 }
}














