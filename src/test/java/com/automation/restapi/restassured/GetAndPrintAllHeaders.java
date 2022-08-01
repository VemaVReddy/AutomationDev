package com.automation.restapi.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAndPrintAllHeaders {

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
		
		Headers allHeaders = response.headers();
		for(Header header: allHeaders) {
			System.out.println(header.getName()+"  "+header.getValue());
		}

	}
}
