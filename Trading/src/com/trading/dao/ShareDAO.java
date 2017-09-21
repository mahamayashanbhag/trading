package com.trading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.trading.util.DBUtil;

public class ShareDAO {

	public void displayShares()
	{
		Connection con = null;
		Statement p1 = null;
		ResultSet rs1 = null;
		
		try {
			con  = DBUtil.getDBConnection();
			p1= con.createStatement();
			rs1 = p1.executeQuery("select * from sharestb");
			while(rs1.next())  
			System.out.println(rs1.getString(1)+" "+rs1.getInt(2)+"  "+rs1.getInt(3));
			
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
		
	

	public int insertShares(String name1,String stkname, int stkno)
	{
		
		
		Connection con = null;
		PreparedStatement p1 = null;
		PreparedStatement p2 = null;
		boolean result = false;
		int rt = 0,rt1=0;
	
				
				try {
					con  = DBUtil.getDBConnection();
					p1 = con.prepareStatement("insert into SHARESOWN values(?,?,?)");
					p1.setString(1, name1);
					p1.setString(2,stkname);
					p1.setInt(3,stkno);
					rt = p1.executeUpdate();
					p2=con.prepareStatement("update SHARESTB set num_share_avail=num_share_avail-(?) where id=(?) ");
					p2.setString(2,stkname);
					p2.setInt(1,stkno);
					rt1 = p2.executeUpdate();
					if(rt>0 && rt1>0)
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
				public int deleteShares(String name2,String stkname1, int stkno1)
				{
					
					
					Connection con = null;
					PreparedStatement p1 = null;
					PreparedStatement p2=null;
					PreparedStatement p3 = null;
					PreparedStatement p4 = null;
					boolean result = false;
					int rt = 0,rt1=0, rt2=0;
					ResultSet rs=null;
				
							
							try {
								con  = DBUtil.getDBConnection();
								p1 = con.prepareStatement("update SHARESOWN set shares_own=shares_own-(?) where name=(?)");
								p1.setInt(1, stkno1);
								p1.setString(2,name2);
								rt = p1.executeUpdate();
								
								p2=con.prepareStatement("select shares_own from SHARESOWN where name=(?)");
								p2.setString(1,name2);
								rs=p2.executeQuery();
								
								if(rs.next()){
									if(rt==1 && rs.getInt("shares_own") == 0){
										p3=con.prepareStatement("delete from SHARESOWN where name=(?)");
										p3.setString(1,name2);
										rt1=p3.executeUpdate();
								}
								}
								
								p4=con.prepareStatement("update SHARESTB set num_share_avail=num_share_avail+(?) where id=(?)");
								p4.setInt(1, stkno1);
								p4.setString(2,stkname1);
								rt2=p4.executeUpdate();
								
								if(rt>0 || rt1>0)
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
		
		
	}		
	
	


