package com.automation.restapi.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequestHeaders {

	@Test
	public void getWeatherDetails() {

		//Specify Base URI
		RestAssured.baseURI = "https://reqres.in/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET, "/api/users");
		
		//print Response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: "+responseBody);
		
		//Validating headers
		String contentType = response.header("Content-Type"); //capture details of Content Type header
		System.out.println("Content Type is: "+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		String contentEncoding = response.header("Content-Encoding"); //capture details of Content Type header
		System.out.println("Content Encoding is: "+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");

	}

	
}
