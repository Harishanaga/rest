package com.rmgyantra_scenario1;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.rmgyantra.POJOlib.POJOClass;

import JavaUtility.BaseClass;
import JavaUtility.EndPoints;
import JavaUtility.Randomnum;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class End2End extends BaseClass
{
	@Test
	public void end2end() throws SQLException
	{
		baseURI = "http://localhost";
		port=8084;
		POJOClass pojo=new POJOClass("shish","harisha"+Randomnum.generateRandomenum(),"created",25);
		
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.post(EndPoints.addPro);
		
		String proId = response.jsonPath().getString("projectId");
		System.out.println(proId);
		
		Response response2 = given()
		.pathParam("projectId", proId)
		.contentType(ContentType.JSON)
		.when()
		.get(EndPoints.getSinglePro);
		
		String proName=response2.jsonPath().get("projectName");
		
		
				dutil.createConnection();
				
				ResultSet res = dutil.executeQuery("select project_name from project;");
				while(res.next())
				{
					if(proName.equals(res.getString(1))) {
						
					
					System.out.println("validation successfull");
					break;
					}
					
				}
				
		dutil.closeConnection();
		System.out.println("connection closed");
	}

}
