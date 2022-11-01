package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import com.rmgyantra.POJOlib.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingpostupdatedelete {
	@Test
	public void chaining()
	{
		POJOClass pojo=new POJOClass("sharish","aa","created",25);
		POJOClass pojo2=new POJOClass("harirish","haaa","created",52);
		
		Response response = given()
		
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject");
		
		String proID1 = response.jsonPath().get("projectId");
		System.out.println(proID1);
		
		Response response2 = given()
		.pathParam("projectId", proID1)
		.contentType(ContentType.JSON)
		.body(pojo2)
		.when()
		.put("http://localhost:8084/projects/{projectId}");
		
		String proId2 = response2.jsonPath().get("projectId");
		System.out.println(proId2);
		
		given()
		.pathParam("projectId", proId2)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
