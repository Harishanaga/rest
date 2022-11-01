package com.rmgyantra.Parameters;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rmgyantra.POJOlib.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Requestchainingcomplete {
@Test
public void requestpost()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "hara");
	jobj.put("projectName", "SDET_9_rest");
	jobj.put("status", "created");
	jobj.put("teamSize", 23);
	
	
	Response rsps = given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.post("http://localhost:8084/addProject");
	
	String proId = rsps.jsonPath().get("projectId");
	given()
	.pathParam("projectId", proId)
	.when()
	.delete("http://localhost:8084/projects/{projectId}")
	.then()
	.log().all();
	
}
}
