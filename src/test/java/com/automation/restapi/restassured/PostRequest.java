package com.automation.restapi.restassured;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void postDetails() {
	//Specify Base URI in below code
			RestAssured.baseURI = "https://reqres.in/";
			
			//Request Object
			RequestSpecification httpRequest = RestAssured.given();
			
			httpRequest.header("Content-Type", "application/json");
			
			JSONObject requestParameters = new JSONObject();
			requestParameters.put("Reddy", "Manager");
			
			httpRequest.body(requestParameters.toString());
			
			//Response object
			Response response = httpRequest.request(Method.POST, "/api/users");
			
			//print Response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response Body: "+responseBody);
			
			//status Code validation
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: "+statusCode);
			Assert.assertEquals(statusCode, 201);
			
			String str = "Hello World";
			char[] ch = str.toCharArray();
			for(char c: ch) {
				
			}
		}


}
