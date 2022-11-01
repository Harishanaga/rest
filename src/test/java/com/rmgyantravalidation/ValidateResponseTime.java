package com.rmgyantravalidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateResponseTime
{
	@Test
	
	public void validateTime()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[2].projectName",Matchers.equalTo("hari"))
		.log().all();
		
		
	}
}
