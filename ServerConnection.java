package myJdbc;

import java.sql.*;
import java.sql.DriverManager;

public class ServerConnection {

	public static void main(String[] args) 
	{
		try
		{
			//postgresql server class loading
			Class.forName("org.postgresql.Driver");
		
			//creating connection
			String url="jdbc:postgresql://localhost:5432/Bala";
			String username="postgres";
			String password="12345";
			Connection con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
