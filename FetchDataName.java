package project1;
import java.sql.*;
import java.util.Scanner;

public class FetchDataName {
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.next();
		sc.close();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from jspider.student where name=?";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			
			//Set the data for the place holder before execution
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				double perc=rs.getDouble(3);
				System.out.println(id+"  "+perc);
			}
			else
			{
				System.err.println("No data found for name: "+name);
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(rs!=null)
			{
				rs.close();
			}
		}
	}
}
