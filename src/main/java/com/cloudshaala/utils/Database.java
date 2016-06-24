
package com.cloudshaala.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cloudshaala.beans.main.UserBean;
import com.cloudshaala.classes.bean.TheClass;

public class Database {
	static Connection con=null;
	public static Connection openConnection()
	{
		
		try{
			if(con==null || con.isClosed())
			{
				Class.forName("com.mysql.jdbc.Driver");
				//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudshaala", "root", "");
				con=DriverManager.getConnection("jdbc:mysql://cloudshaala.com:3306/cloudshaala",
						"cloudshaala", "cloudshaala");
				
			}
		}catch(Exception ex)
		{
			System.out.println("cloudshaala:+db connection error:"+ex.toString());
		}
		return con;
	}
public	static Long getClassId(TheClass theClass)
	{
		Long classId=-1l;
		String query="select * from class where course_id=? and section=? and academic_sesion=? and institution_id=?";
		try{
			Connection con=Database.openConnection();
						PreparedStatement pst=con.prepareStatement(query);
			pst.setLong(1, theClass.getCourse().getId());
			pst.setLong(2, theClass.getSection());
			pst.setLong(3, theClass.getAcademicSession());
			pst.setLong(4, theClass.getInstitutionId());
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				classId=rs.getLong("id");
				theClass.setId(classId);
			}
			rs.close();
			pst.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return classId;
	}
	public static TheClass saveClass(TheClass theClass)
	{
		if(getClassId(theClass)==-1)
		{	
		boolean insertSuccess=false;
		Connection con=Database.openConnection();
		String query="insert into class (title, course_id,institution_id,section,acamedic_session, "
				+ "created_by, class_teacher_id) values(?,?,?,?,?,?,?)";
			try{
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,theClass.getTitle());
				pst.setLong(2, theClass.getCourse().getId());
				pst.setLong(3, theClass.getInstitutionId());
				pst.setLong(4, theClass.getSection());
				pst.setLong(5, theClass.getAcademicSession());
				pst.setLong(6, theClass.getCreatedBy());
				pst.setLong(7, theClass.getClassTeacher().getId());
				
				int rows=pst.executeUpdate();
				pst.close();
				if(rows>=1)
				{
					insertSuccess=true;
				}
				
				pst.close();
				con.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(insertSuccess)
			{
				getClassId(theClass);
			}
		}
		return theClass;
	}
}
