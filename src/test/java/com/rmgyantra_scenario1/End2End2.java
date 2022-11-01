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

public class End2End2 extends BaseClass{
@Test
public void end2end2() throws SQLException
{

	POJOClass pojo1=new POJOClass("hai","Harsha"+Randomnum.generateRandomenum(),"created",99);
	POJOClass pojo2=new POJOClass("hai","Harish"+Randomnum.generateRandomenum(),"created",99);
	//String expectedProjectName = "hahharish";
	baseURI="http://localhost";
	port=8084;
	Response response1 = given()
	.contentType(ContentType.JSON)
	.body(pojo1)
	.when()
	.post(EndPoints.addPro);
	
	String proId = response1.jsonPath().getString("projectId");
	System.out.println(proId);
	
	Response reponse2 = given()
	.pathParam("projectId", proId)
	.contentType(ContentType.JSON)
	.body(pojo2)
	.when()
	.put(EndPoints.updatePro);
	

	given()
	.pathParam("projectId", proId)
	.when()
	.delete(EndPoints.deletePro);

		dutil.createConnection();
			ResultSet res = dutil.executeQuery("select project_name from project;");
			
		
			while(res.next())
			{
				if(!proId.equals(res.getString(1)))
				{
					System.out.println("valiadtin success");
					break;
				}
			}
		dutil.closeConnection();
		
}
}
