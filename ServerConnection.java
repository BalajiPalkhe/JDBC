package myJdbc;

import java.sql.*;

public class ServerConnection {


			//postgresql server class loading
	ServerConnection() throws SQLException
	{
			//Class.forName("org.postgresql.Driver");
		
			//creating connection
			String url="jdbc:postgresql://localhost:5432/Bala";
			String username="postgres";
			String password="12345";
			Connection con=DriverManager.getConnection(url,username,password);
	

	}
}


