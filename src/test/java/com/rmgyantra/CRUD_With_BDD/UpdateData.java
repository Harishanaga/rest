package com.rmgyantra.CRUD_With_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateData {
@Test
public void updatingdata()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "haaa");
	jobj.put("projectName", "SDET_9_restassured");
	jobj.put("status", "created");
	jobj.put("teamSize", 77);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_205")
	.then()
	.assertThat().statusCode(200)
	.log().all();
}
}
