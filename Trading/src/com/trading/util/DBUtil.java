package com.trading.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String driverName="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String username="mahamaya";
	private static final String password="mahamaya";
	
	public static Connection getDBConnection()
	{
		Connection con = null;
		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,username,password);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}

		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		return con;
	}
}
