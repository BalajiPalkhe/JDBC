package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QueryselectName 
{
	
	public static void main(String[] args) {
		
		try {
		String url="jdbc:postgresql://localhost:5432/Bala";
		String username="postgres";
		String password="12345";
		Connection con=DriverManager.getConnection(url,username,password);

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Query : ");
		String s=sc.nextLine();

		Statement ss=con.createStatement();
		
		int a=ss.executeUpdate(s);
		
		System.out.println("Updated "+a+"Rows");
		
		con.close();
		sc.close();
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
