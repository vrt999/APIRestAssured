package com.restAssured.API;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class BasicAuthRestAssured {
	
	@Test
	public void basicAuthRestAssuredTest() {
		
		Response response  = given().
								auth().
								preemptive().
								basic("ToolsQA", "TestPassword").
							 when().
							 	get("http://restapi.demoqa.com/authentication/CheckForAuthentication/").
							 then().
							 	extract().response();
		int statuscode  = response.getStatusCode();		
		Assert.assertEquals(200, statuscode);		
		System.out.println("The received status code: " + statuscode);		
	}

}
