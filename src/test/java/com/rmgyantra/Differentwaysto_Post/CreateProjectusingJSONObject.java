package com.rmgyantra.Differentwaysto_Post;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectusingJSONObject {
	@Test
	public void creatingproject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "harshaaa");
		jobj.put("projectName", "SDET_9_rest1223q");
		jobj.put("status", "created");
		jobj.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}
