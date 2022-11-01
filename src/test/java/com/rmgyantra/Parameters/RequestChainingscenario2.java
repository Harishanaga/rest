package com.rmgyantra.Parameters;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.rmgyantra.POJOlib.POJOClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestChainingscenario2 {
@Test
public void scenario2() throws Throwable
{
	POJOClass pojo1=new POJOClass("hai","dkda","created",99);
	POJOClass pojo2=new POJOClass("hai","hdsh","created",99);
	//String expectedProjectName = "hahharish";
	
	Response response1 = given()
	.contentType(ContentType.JSON)
	.body(pojo1)
	.when()
	.post("http://localhost:8084/addProject");
	
	String projectID = response1.jsonPath().get("projectId");
	System.out.println(projectID);
	
	Response reponse2 = given()
	.pathParam("projectId", projectID)
	.contentType(ContentType.JSON)
	.body(pojo2)
	.when()
	.put("http://localhost:8084/projects/{projectId}");
	

	given()
	.pathParam("projectId", projectID)
	.when()
	.delete("http://localhost:8084/projects/{projectId}");

	Connection con=null;
	{
		try
		{
			String projectID1 = projectID;
			com.mysql.cj.jdbc.Driver dre = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(dre);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select project_name from project;");
			while(res.next())
			{
				if(!projectID1.equals(res.getString(1)))
				{
					System.out.println("valiadtin success");
					break;
				}
			}
		}
		catch(Exception e)
		{
			
		}
		finally {
			con.close();
			System.out.println("connection closed");
		}
	}
}

}
