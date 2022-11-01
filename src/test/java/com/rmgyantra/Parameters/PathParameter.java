package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void pathaparam()
	{
		given()
		.pathParam("proId", "TY_PROJ_001")
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
