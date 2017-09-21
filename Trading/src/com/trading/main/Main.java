package com.trading.main;

import java.util.Scanner;

import com.trading.dao.ShareDAO;
import com.trading.dao.UserDAO;

public class Main {
	
	public static void main(String args[]) {
	
	 String name, password;	
	 Scanner sc= new Scanner(System.in);
	 
	ShareDAO share=new ShareDAO();
	System.out.println("The Share List:");
	share.displayShares();
	//-----------------------------------------------------------------
	
	System.out.println("Enter the name of the user");
	name=sc.nextLine();
	System.out.println("Enter the password");
	password=sc.nextLine();
	UserDAO user= new UserDAO();
	int result=user.createUser(name, password);
	if(result==1)
	{
		System.out.println("User has been registered");
		
	}
	else
	{
		System.out.println("User has not been registered");
	
	}
	
	
	System.out.println("Enter 1 to display list of users");
	int num=sc.nextInt();
	if(num==1)
	{
		user.displayUsers();
	}
	else
	{
		System.out.println("Users table cannot be displayed");
	}
	
	//------------------------------------------------------------------------------------------------
	
	
		
	System.out.println("Enter the name of the user");
	String name1=sc.nextLine();
	
	System.out.println("Enter the password");
	String password1=sc.nextLine();
	
	UserDAO loginuser= new UserDAO();
	int result1=loginuser.searchUser(name1,password1);
	if(result1==1)
	{
		System.out.println("User logged in");
	}
	else
	{
		System.out.println("User not present/ Invalid username and password");
		System.exit(0);
	}
	share.displayShares();
	if(result1==1)
	{
			share.displayShares();
			System.out.println("Enter the no. of stocks you want to buy");
			int n=sc.nextInt();
			
			System.out.println("Enter the stock");
			String stkname=sc.next();
			
			System.out.println("Enter the number of stocks");
			int stkno=sc.nextInt();
			ShareDAO share1=new ShareDAO();
			int res=share1.insertShares(name1, stkname, stkno);
			if(res==1)
			{
				System.out.println("Stock purchased");
			}
			else
			{
				System.out.println("Stocks not available");
			}
	
	}
	
	//----------------------------------------------------------------------------------------------------
	
	//Scanner sc= new Scanner(System.in);
	System.out.println("Enter the name of the user");
	String name2=sc.nextLine();
	System.out.println("Enter the password");
	String password2=sc.nextLine();
	UserDAO loginuser2= new UserDAO();
	int result2=loginuser2.searchUser(name2,password2);
	if(result2==1)
	{
		System.out.println("User logged in");
	}
	else
	{
		System.out.println("User not present/ Invalid username and password");
		System.exit(0);
	}
	
	if(result2==1) {
		
		System.out.println("Enter the stock you want to sell");
		String stkname1=sc.nextLine();
		System.out.println("Enter the number of stocks you want to sell");
		int stkno1=sc.nextInt();
		ShareDAO share2= new ShareDAO();
		int res2=share2.deleteShares(name2,stkname1,stkno1);
		if(res2==1){
			System.out.println("Shares have been sold");
		}
		else
		{
			System.out.println("Not able to sell the shares");
		}
		
	}
	
	
	
	
	
	}
	
}


