
package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
@Test
public void queryParam()
{
	given()
	.pathParam("username", "Harishanaga") 	//github details
	.queryParam("sort", "projectName")		//filtering/sorting  the elementing
	.when()
	.get("https://api.github.com/users/{username}/repos")
	
	.then()
	.log().all();
}
}
