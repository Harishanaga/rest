package com.rmgyanra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2O {
@Test
public void Oauth()
{
	Response rsps = given()
	.formParam("client_id", "SDET@9")	//from 1)Authentication  2)API/your application/ sdet@9
	.formParam("client_secret", "ba5333e1ac53ffc7572df5dff8776ad2")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "https://example.com")
	.when()
	.post("http://coop.apps.symfonycasts.com/token");	//Authenticationx
	
	String token = rsps.jsonPath().get("access_token");
	System.out.println(token);
	
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", "3967")
	.when()
	.post("http://coop.apps.symfonycasts.com/application/api/{USER_ID}/chickens-feed")
	.then()
	.log().all();
}
}
