package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author Hp Lap
 *
 */
public class DataBaseUtility {
   static  Driver driverRef;
   static Connection connection;
   static ResultSet result;
    /**
     * This method is used to connect database
     * @param DBname 
     * @throws SQLException
     */
	public void connectToDB() throws SQLException
	{
		try {
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		DriverManager.getConnection(Iconstants.DbUrl,Iconstants.DbUsername, Iconstants.DbPassword);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the database connection
	 */
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
	/**
	 * This method is used to execute the query
	 * @param query
	 * @param coloumnNum
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean executeQuery(String query, int coloumnNum, Object expectedData) throws SQLException
	{
		result=connection.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if (result.getString(coloumnNum).equals(expectedData))
			{
				flag = true;
				break;
			}
		}
			if (flag) {
				System.out.println("data is present");
				return flag;
			}
			else
			{
				System.out.println("data is not present");
				return flag;
			}
	}
	
	    
		public void executeUpdatee(String query) throws SQLException
		{
			int res = connection.createStatement().executeUpdate(query);
			if(res==1)
			{
				System.out.println("data is updated");
			}
			else
			{
				System.out.println("data is not updated");
			}
		}
	
	
}

