package myJdbc;

import java.sql.*;
import java.util.Scanner;

public class QueryDetection
{
	static Connection con=null;
	static Scanner sc=new Scanner(System.in);
	QueryDetection() throws SQLException 
	{
		super();
		con=PostgresConnection.getPostgresConnection();
	}
	public static void main(String[] args) throws SQLException 
	{
		while(true)
		{
			System.out.println("Enter Query : ");
			String s=sc.nextLine();

			tname(s);
			String s2=tname(s);
			
			if(s2.contains("tname"))
			{
				tName(s);
			}
			else if(s2.contains("*"))
			{
				showTable(s);
			}
			else if(s2.contains("tCity"))
			{
				tCity(s);
			}
			else if(s2.contains("tid"))
			{
				tid(s);
			}
			else if(s2.contains("update"))
			{
				Update(s);
			}
			else if(s2.contains("insert"))
			{
				Insert(s);
			}
		}
	}
	
	static String tname(String s)
	{
		String s2="";
		for (int i = 0; i < 10; i++) 
		{
			s2=s2+s.charAt(i);
		}
		return s2;
	}
		
	static void tName (String s) throws SQLException 
	{
		con=PostgresConnection.getPostgresConnection();
		Statement ss=null;
		ResultSet set=null;
		try 
		{
			ss=con.createStatement();
			
			set=ss.executeQuery(s);
		
		while(set.next())
		{
			String tname=set.getString("tname");
			
			System.out.println(tname);
		}
		PostgresConnection.cleanUp(con, ss);

	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void showTable(String s) throws SQLException
	{
		con=PostgresConnection.getPostgresConnection();	
		Statement ss=null;
		ResultSet set=null;
		try {
			ss=con.createStatement();
			
			set=ss.executeQuery(s);
			while(set.next())
			{
				int id=set.getInt("tid");
				String tname=set.getString("tname");
				String tCity=set.getString("tCity");
				
				System.out.println(id+" "+tname+" "+tCity);
			}
			PostgresConnection.cleanUp(con, ss);

		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	static void tCity (String s) throws SQLException 
	{
		con=PostgresConnection.getPostgresConnection();		
		Statement ss=null;
		ResultSet set=null;
		try 
		{
			ss=con.createStatement();
			
			set=ss.executeQuery(s);
		
		while(set.next())
		{
			String tCity=set.getString("tCity");
			
			System.out.println(tCity);
		}
		PostgresConnection.cleanUp(con, ss);
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void tid (String s) throws SQLException 
	{
		con=PostgresConnection.getPostgresConnection();		
		Statement ss=null;
		ResultSet set=null;
		try 
		{
			ss=con.createStatement();
			
			set=ss.executeQuery(s);
		
		while(set.next())
		{
			int tid=set.getInt("tid");
			
			System.out.println(tid);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		PostgresConnection.cleanUp(con,ss,set);	
	}
	
	static void Update (String s) throws SQLException 
	{
		con=PostgresConnection.getPostgresConnection();		
		try {
		Statement ss=con.createStatement();
		
		int a=ss.executeUpdate(s);
		
		System.out.println("Updated "+a+" Rows");
		
		con.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	static void Insert (String s) throws SQLException 
	{
		con=PostgresConnection.getPostgresConnection();		
		try {
			
			
			String q="insert into table1(tid,tname,tCity) values (?,?,?)";

			//create a PreparedStatement-----------
			
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//taking inputs from user---------
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter tid");
			int tid=sc.nextInt();		
			System.out.println("Enter tname");
			String tname=sc.next();
			System.out.println("Enter tCity");
			String tCity=sc.next();
			
			//set values-------------
			pstmt.setInt(1, tid);
			pstmt.setString(2, tname);
			pstmt.setString(3, tCity);	
					
			//execution of query
			pstmt.execute();
			
			System.out.println("inserted.....");
			
			//closed the object--------------
			con.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
