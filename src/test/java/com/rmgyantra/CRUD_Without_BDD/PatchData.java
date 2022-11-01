package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PatchData {
@Test
public void partialUpdate()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "harishaaa");
	
	
	RequestSpecification reqspec = RestAssured.given();
	reqspec.contentType(ContentType.JSON);
	reqspec.body(jobj);
	Response rsps = reqspec.patch("https://reqres.in/api/users/2");
	ValidatableResponse vres = rsps.then();
	vres.assertThat().statusCode(200);
	vres.log().all();
}
}
