
package com.cloudshaala.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	static Connection con=null;
	public static Connection openConnection()
	{
		
		try{
			if(con==null || con.isClosed())
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudshaala", "root", "");
				
			}
		}catch(Exception ex)
		{
			System.out.println("cloudshaala:+db connection error:"+ex.toString());
		}
		return con;
	}
}
