package com.rmgyantra.CRUD_With_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteData 
{
@Test
public void deletingproject()
{
	when()
	.delete("http://localhost:8084/projects/TY_PROJ_206")
	.then()
	.assertThat().statusCode(204)
	.and().assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
