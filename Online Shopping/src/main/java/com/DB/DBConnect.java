package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {

	private static Connection con;
	
	public static Connection getCon() 
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","polash");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return con;
	}
	
}
