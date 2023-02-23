package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertInto
{

	public static void main(String[] args) 
	{

		try
		{
			
			
			//postgresql server class loading
			Class.forName("org.postgresql.Driver");
//		
//			//creating connection
			String url="jdbc:postgresql://localhost:5432/Bala";
			String username="postgres";
			String password="12345";
			Connection con=DriverManager.getConnection(url,username,password);
			
			//creating a query
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
