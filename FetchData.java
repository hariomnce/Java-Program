package project1;

import java.sql.*;

public class FetchData {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from jspider.student";

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform is Created");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				System.out.println(id+"  "+name+"  "+perc);
			}
		}
		catch (ClassNotFoundException | SQLException e)
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
			System.out.println("Closed all the costly resources");
		}
	}
}
