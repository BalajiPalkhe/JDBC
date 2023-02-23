package myJdbc;

import java.sql.*;

class JdbcP
{
	
	public static void main(String[] args)
	{
		
		try
		{
			//postgresql server class loading
			Class.forName("org.postgresql.Driver");
		
			//creating connection
			String url="jdbc:postgresql://localhost:5432/postgres";
			String username="postgres";
			String password="12345";
			Connection con=DriverManager.getConnection(url,username,password);
			
			//creating a query
			String q="select * from hef.student";

			//create a statement
			
			Statement stmt=con.createStatement();
			
			//execution of query
			
			ResultSet set=stmt.executeQuery(q);
			
			//update of query
		//	stmt.executeUpdate(q);
			
			while(set.next())
			{
				int id=set.getInt("id");
				String tname=set.getString("Name");
				
				System.out.println(id+" "+tname);
			}
			con.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}