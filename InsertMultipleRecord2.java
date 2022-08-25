package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class InsertMultipleRecord2 {
	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into qspider.student values(?,?,?)";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection is Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform is created");
			//we set the value for the placeholder
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Ankit");
			pstmt.setDouble(3, 80.4);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Prashant");
			pstmt.setDouble(3, 86.6);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Mahindra");
			pstmt.setDouble(3, 90.6);
			pstmt.executeUpdate();
			System.out.println("Data is inserted successfully...");
		}
		catch (ClassNotFoundException | SQLException e) 
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