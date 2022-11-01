package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateData
{
@Test
public void createProject()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "harishaaa");
	jobj.put("projectName","SDET_9_Restassured");
	jobj.put("status", "created");
	jobj.put("teamSize", 10);
	
	RequestSpecification reqspec = RestAssured.given();
	reqspec.contentType(ContentType.JSON);
	reqspec.body(jobj);
	Response rsps = reqspec.post("http://localhost:8084/addProject");
	ValidatableResponse vres = rsps.then();
	vres.assertThat().statusCode(201);
	vres.log().all();
}
}
