package com.rmgyanra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarerToken {
@Test
public void barertoken()
{
	given()
	.auth().oauth2("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")
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.assertThat().statusCode(200)
	.log().all();
}
}
