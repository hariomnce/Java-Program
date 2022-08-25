package project1;

import java.sql.DriverManager;
import java.sql.*;
public class Program3 {
	public static void main(String[] args) {
		Connection con=null;
		Statement smt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			smt=con.createStatement();
			System.out.println("Statement is created");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
