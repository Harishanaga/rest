package com.rmgyantra.CRUD_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PatchData {
@Test
public void partialData()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "hdcdj");
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.patch("https://reqres.in/api/users/2")
	.then()
	.assertThat().statusCode(200)
	.log().all();
	
}
}
