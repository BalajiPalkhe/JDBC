package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresConnection 
{
	public static Connection getPostgresConnection() 
	{
		Connection con=null;
		try 
		{
			String url="jdbc:postgresql://localhost:5432/Bala";
			String username="postgres";
			String password="12345";
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void cleanUp(Connection con, Statement st)
	{
		try
		{
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void cleanUp(Connection con, Statement st,ResultSet rs)
	{
		try
		{
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
			if(rs!=null)
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
