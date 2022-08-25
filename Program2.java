package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Program2 {
	public static void main(String[] args) {
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
