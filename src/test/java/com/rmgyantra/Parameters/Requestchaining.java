package com.rmgyantra.Parameters;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Requestchaining {
@Test
public void request()
{
	Response rsps = when()
	.get("http://localhost:8084/projects");
	
	String proId = rsps.jsonPath().get("[1].projectId");
	System.out.println(proId);
	
	given()
	.pathParam("projectId", proId)
	.when()
	.delete("http://localhost:8084/projects/{projectId}")
	.then()
	.log().all();
	
	
}

}
