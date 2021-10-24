package com.restAssured.API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Scanner;

public class DeleteRequestRestAssured {
	
	@Test
	public void deleteRequestTest() {
		
		int id = 1;
		Scanner sc = new Scanner(System.in);
//		while(id != 0) {	
		System.out.println("Enter the ID to be deleted: ");
		id = sc.nextInt();
		
			
		RestAssured.baseURI = "http://localhost:3000";
		Response response  = 
				given().
					header("Content-Type","application/json").
				when().
					delete("posts/" + id).
				then().
					statusCode(200).and().
					extract().response();
		
		System.out.println("The response status code : " + response.getStatusCode());	
		System.out.println("The output response : " + response.asString());	
//		}
		
		sc.close();
//		[typicode, null, typicode364, typicode348, typicode904, typicode135, typicode46, typicode970, typicode365, typicode366, author977, author386]
		
	}

}
