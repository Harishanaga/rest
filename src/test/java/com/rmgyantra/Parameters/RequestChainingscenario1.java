package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.rmgyantra.POJOlib.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestChainingscenario1 {
@Test
public void scenarion() throws SQLException
{
	POJOClass pojo=new POJOClass("shish","ahhaah","created",25);
	
	
	Response response = given()
	.contentType(ContentType.JSON)
	.body(pojo)
	.post("http://localhost:8084/addProject");
	
	String proId = response.jsonPath().getString("projectId");
	System.out.println(proId);
	
	Response response2 = given()
	.pathParam("projectId", proId)
	.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:8084/projects/{projectId}");
	
	String proName=response2.jsonPath().get("projectName");
	
	Connection con=null;
	{
		try
		{
			com.mysql.cj.jdbc.Driver dre = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(dre);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select project_name from project;");
			while(res.next())
			{
				if(proName.equals(res.getString(1))) {
					
				
				System.out.println("validation successfull");
				break;
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("exception  thrown");
		}
	}con.close();
	System.out.println("connection closed");
}
}
