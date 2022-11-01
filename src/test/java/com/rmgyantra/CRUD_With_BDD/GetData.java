package com.rmgyantra.CRUD_With_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetData {


@Test
public void getProject()
{
	given()
	.get("http://localhost:8084/projects")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
