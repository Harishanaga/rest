package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UpdateData {
	@Test
	public void updateproject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "harsha");
		jobj.put("projectName", "SDET_9_Restassured");
		
		jobj.put("status", "created");
		jobj.put("teamSize", 8);
		
		RequestSpecification reqspec = RestAssured.given();		//given
		reqspec.body(jobj);
	 reqspec.contentType(ContentType.JSON);
	 
		 Response rsps = reqspec.put("http://localhost:8084/projects/TY_PROJ_206");		//when
		
		  ValidatableResponse vres = rsps.then();		//then
		  vres.assertThat().statusCode(200);
		  vres.log().all();
		
		
		
		
	}
}
