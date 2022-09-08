package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class BaseClass {

	static  Driver driverRef;
	static Connection connection;
	static ResultSet result;

	public void connectToDB(String DBname) throws SQLException
	{
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			DriverManager.getConnection(Iconstants.DbUrl+DBname,Iconstants.DbUsername, Iconstants.DbPassword);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void closeDB()
	{
		try {
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
