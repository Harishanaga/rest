package com.rmgyantra.CRUD_Without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class deleteData {
	@Test
	public void removeData()
	{
		Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_203");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(204);
		vres.assertThat().contentType(ContentType.JSON);
		vres.log().all();
		
	}
}
