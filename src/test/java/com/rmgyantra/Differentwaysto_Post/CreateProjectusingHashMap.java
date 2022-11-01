package com.rmgyantra.Differentwaysto_Post;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectusingHashMap {
	@Test
	public void creatingproject()
	{
		HashMap hp=new HashMap();
		hp.put("createdBy", "harshaaaa1020");
		hp.put("projectName", "SDET_19_restassured");
		hp.put("status", "created");
		hp.put("teamSize", 77);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}
