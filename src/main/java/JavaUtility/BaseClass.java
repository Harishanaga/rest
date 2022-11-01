package JavaUtility;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public DatabaseUtility dutil=new DatabaseUtility();
	
	@BeforeSuite()
	public void createcon() throws SQLException
	{
		dutil.createConnection();
	}
	
	@AfterSuite()
	public void closecon() throws SQLException
	{
		dutil.closeConnection();
	}
}
