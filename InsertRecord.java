package project1;
import java.sql.*;
public class InsertRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement smt=null;
		String qry1="insert into jspiders.student values(12,'Sohan',88.2)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection is established");
			smt=con.createStatement();
			System.out.println("Statement is created");
			smt.execute(qry1);
			System.out.println("Data is inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(smt!=null)
			{
				try
				{
					smt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
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
		System.out.println("Costly resources closed");
	}
}
