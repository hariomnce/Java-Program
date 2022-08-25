package project1;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement smt=null;
		String qry1="insert into jspiders.student values(2,'Hariom',78.2)";
		String qry2="insert into jspiders.student values(3,'Vimal',78.4)";
		String qry3="insert into jspiders.student values(4,'Raja',80.6)";
		String qry4="insert into jspiders.student values(5,'Mihir',82.8)";
		String qry5="insert into jspiders.student values(6,'Prashant',88.4)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection is established");
			smt=con.createStatement();
			System.out.println("Statement is created");
			smt.execute(qry1);
			smt.execute(qry2);
			smt.execute(qry3);
			smt.execute(qry4);
			smt.execute(qry5);
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
