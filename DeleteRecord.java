package project1;
import java.sql.*;
public class DeleteRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement smt=null;
		String qry1="delete from jspider.student where id=3";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection is established");
			smt=con.createStatement();
			System.out.println("Statement is created");
			smt.execute(qry1);
			System.out.println("Data is delete");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
