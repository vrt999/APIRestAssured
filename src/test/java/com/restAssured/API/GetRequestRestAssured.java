package com.restAssured.API;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class GetRequestRestAssured {
	
	public static void main(String[] args) throws Exception {
		
		GetRequestRestAssured demo = new GetRequestRestAssured();
		
		demo.getAPITest1();
		demo.getAPITest2();
		
	}
	
	public void getAPITest1() {
//		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22");
		Response response = RestAssured.get("http://localhost:3000/posts/");		
		
		int respcode = response.getStatusCode();
		
		Assert.assertEquals(200, respcode);
		System.out.println("The Response : " + response.asString());
		System.out.println("The Response time : " + response.getTimeIn(TimeUnit.SECONDS));
	}
	
	public void getAPITest2() throws Exception {
		
		given().get("http://localhost:3000/posts/1").
		then().statusCode(200).
		log().all();
		
	}

} 
