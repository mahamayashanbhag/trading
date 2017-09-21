package com.trading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trading.util.DBUtil;

public class UserDAO {
	
	public int createUser(String name, String password)
	{
		Connection con = null;
		PreparedStatement p1 = null;
		boolean result = false;
		int rt = 0;
	
				
				try {
					con  = DBUtil.getDBConnection();
					p1 = con.prepareStatement("insert into USERSTB values(?,?)");
					p1.setString(1, name);
					p1.setString(2, password);
					rt = p1.executeUpdate();
					if(rt>0)
					{
						result = true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(result == true)
				{
					return 1;
				}
				else
				{
					return 0;
				}
	
	}
	
	public void displayUsers()
	{
		Connection con = null;
		Statement p1 = null;
		ResultSet rs1 = null;
		
		try {
			con  = DBUtil.getDBConnection();
			p1= con.createStatement();
			rs1 = p1.executeQuery("select * from userstb");
			while(rs1.next())  
			System.out.println(rs1.getString(1)+"  "+rs1.getString(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int searchUser(String name1, String password1)
	{
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs1 = null;
		boolean result = false;
		try {
			con  = DBUtil.getDBConnection();
			p1 = con.prepareStatement("select * from userstb where name=(?) and password=(?)");
			p1.setString(1, name1);
			p1.setString(2, password1);
			rs1 = p1.executeQuery();
			if(rs1.next())
			{
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(result==true)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}	

