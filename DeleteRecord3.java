package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecord3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();

		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="delete from qspider.student where id=?";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Loaded...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection is Established...");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform is Created");

			//we set the value for the placeholder
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Data deleted Successfully...");
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
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}