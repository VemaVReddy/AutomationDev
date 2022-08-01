package com.automation.restapi.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequest {
	
	@Test
	public void getWeatherDetails() {

		//Specify Base URI
		RestAssured.baseURI = "https://www.orangehrm.com/features";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET, "/hr-administration");
		
		//print Response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: "+responseBody);
		
		//status Code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
