package com.rmgyantra.Differentwaysto_Post;

import org.testng.annotations.Test;

import com.rmgyantra.POJOlib.POJOClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectusingPOJOClass
{
	@Test
	public void createProject()
	{
		POJOClass pojo=new POJOClass("harsha123","SDET_9_POJOClass","completed",67);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();
		
	}
}
