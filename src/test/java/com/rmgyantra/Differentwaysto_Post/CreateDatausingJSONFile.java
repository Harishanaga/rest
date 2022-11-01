package com.rmgyantra.Differentwaysto_Post;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateDatausingJSONFile 
{
	@Test
	public void createProject()
	{
		File f=new File("./Data.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(f)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();
	}
}
