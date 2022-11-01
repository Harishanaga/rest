package JavaUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	public Connection con;
	
	public void createConnection() throws SQLException
	{
		com.mysql.cj.jdbc.Driver dre = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dre);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	}
	
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	public ResultSet executeQuery(String statement) throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(statement);
		return res;
	}
}
