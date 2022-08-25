package project1;
import java.sql.*;
import java.util.Scanner;
public class InsertRecord2 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the perc");
		double perc=sc.nextDouble();
		
		Connection con=null;
		PreparedStatement smt=null;
		
		String qry1="insert into jspider.student values(?,?,?)";
		//String qry1="select * from jspider where id=3";
		//SQL Exception generate because of DQL Query
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection is established");
			smt=con.prepareStatement(qry1);
			System.out.println("Statement is created");
			//SET THE VALUE FOR THE PLACE HOLDER
			smt.setInt(1, id);
			smt.setString(2, name);
			smt.setDouble(3, perc);
			smt.execute();
			System.out.println("Data is inserted");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}


















