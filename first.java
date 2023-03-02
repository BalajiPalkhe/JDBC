package myJdbc;

import java.sql.*;

class JdbcP
{
	
	public static void main(String[] args)
	{
		
		try
		{
			//postgresql server class loading
			//Class.forName("org.postgresql.Driver");
		
			//creating connection
			String url="jdbc:postgresql://localhost:5432/Bala";
			String username="postgres";
			String password="12345";
			Connection con=DriverManager.getConnection(url,username,password);
			
			//creating a query
			String q="select * from table1 where  tname like'%1'";

			//create a statement
			
			PreparedStatement stmt=con.prepareStatement(q);
			
			//execution of query
			
			ResultSet set=stmt.executeQuery();
			
			//update of query
		//	stmt.executeUpdate(q);
			
			while(set.next())
			{
				int id=set.getInt("tid");
				String tname=set.getString("tname");
				String tCity=set.getString("tCity");
				
				System.out.println(id+" "+tname+" "+tCity);
			}
			con.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}