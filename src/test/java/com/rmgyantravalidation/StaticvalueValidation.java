package com.rmgyantravalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticvalueValidation {
@Test
public void staticValidation()
{
	String expProName = "SDET_9_restassured";
	Response rsps = when()
			.get("http://localhost:8084/projects");
	
	String actProName = rsps.jsonPath().get("[2].projectName");
	System.out.println(actProName);
	
	Assert.assertEquals(actProName, expProName);
}



}
