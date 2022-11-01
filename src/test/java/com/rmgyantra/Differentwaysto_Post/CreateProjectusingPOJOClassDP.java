package com.rmgyantra.Differentwaysto_Post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.POJOlib.POJOClass;

import io.restassured.http.ContentType;

public class CreateProjectusingPOJOClassDP 
{

	//private static final String[][] Object = null;

	@Test(dataProvider="provideData")
	public void createProject(String createdBy,String projectName,String status,int teamSize)
	{
		POJOClass pojo=new POJOClass(createdBy,projectName,status,teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();
		
	}
	
	@DataProvider()
	public Object[][] provideData()
	{
		Object[][] obj=new Object[2][4];
		obj[0][0]="harisha7859";
		obj[0][1]="SDET_9_POJODP";
		obj[0][2]="complete";
		obj[0][3]=12;
		
		
		obj[1][0]="harisha1012";
		obj[1][1]="SDET_9_POJODProv";
		obj[1][2]="complete";
		obj[1][3]=22;
		return obj;
	}
}
