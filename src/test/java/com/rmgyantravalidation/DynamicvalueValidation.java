package com.rmgyantravalidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class DynamicvalueValidation {
@Test
public void dynamicvalidation()
{
	String expProName="SDET_9_restassured";
	 Response rsps = when()
			 .get("http://localhost:8084/projects");
	 
	List<String> actProList = rsps.jsonPath().get("projectName");
	int count=actProList.size();
	for(int i=0;i<count;i++)
	{
		String actProName=actProList.get(i);
		if(expProName.equals(actProName))
		{
			System.out.println(expProName+"is available");
			break;
		}
	}
}
}
