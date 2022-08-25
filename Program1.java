package project1;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Program1 {
	public static void main(String[] args) {
		//Loading the Driver class manually which is not a good pratice
		
		//Driver d=new Driver();
		//DriverManager.registerDriver(d);
		//System.out.println("Driver is loaded");
		
		//Good pratice to load and register the driver by using forname().
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("The driver is loaded by using forname(). ");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
