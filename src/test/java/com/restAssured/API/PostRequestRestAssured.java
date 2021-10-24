package com.restAssured.API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.with;

class JSONInputdata {
	private int id;
	private String title;
	private String author;
	
	public JSONInputdata(int id,String title,String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}

class JSONOutputdata {
	private int id;
	private String title;
	private String author;
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}

//PUT Reuqest is also same as post request 

//generate the headers 
//Gneerate body with whatever way possible like JSONFile,JSONObject,Java Object
//Trigger a PUT command on the request

public class PostRequestRestAssured {

	@Test(priority = 1, enabled = false)
	public void postRestAssuredTest1() {

		JsonObject j = new JsonObject();
		int randomid = new Random().nextInt(1000);
		System.out.println("The Randomid : " + randomid);

		j.addProperty("id", randomid);
		j.addProperty("title", "json-server" + randomid);
		j.addProperty("author", "typicode" + randomid);

		System.out.println("The JSON Object is : " + j);

		// String jsonstring = j.toJSONString();

		// System.out.println("The JSON String is: " + jsonstring);

		RestAssured.baseURI = "http://localhost:3000";

		given().header("Content-Type", "application/json").and().body(j.toString()).when().post("/posts").then()
				.statusCode(201).and().log().all();

	}

	@Test(priority = 2, enabled = false)
	public void postRestAssuredTestUsingJsonObject() {
		RestAssured.baseURI = "http://localhost:3000";

		JSONObject requestParams = new JSONObject();
		int randomid = new Random().nextInt(1000);
		System.out.println("The Randomid : " + randomid);

		requestParams.put("id", randomid);
		requestParams.put("title", "json-server" + randomid);
		requestParams.put("author", "typicode" + randomid);

		RequestSpecification request = given();
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());

		Response response = request.post("/posts");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		System.out.println("The Response String : " + response.asString());
	}
	
	@Test(enabled = false)
	public void postRestAssuredTestUsingJsonFile() throws Exception {
		
		FileInputStream fip = new FileInputStream(".\\Data Files\\testdatafile1.json");
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = given();
		
		request.header("Content-Type","application/json");
		request.body(fip);
		
		Response response  = request.post("/posts");
		
		int statuscode = response.getStatusCode();
		
		Assert.assertEquals(statuscode, 201);
		
		System.out.println("The Response String : " + response.asString());
		
/*		given().
			header("Content-Type","application/json").and().
			body(fip).
		when().
			post("/posts").
		then().
			statusCode(201).and().
			log().all();*/
			
		
		
	}
	
	@Test
	public void postRequestTestUsingJavaClassObject() {
		
		int randomid = new Random().nextInt(1000);
		JSONInputdata jsoninputdata = new JSONInputdata(randomid,"title" + randomid,"author" + randomid);
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response = given()
			.header("Content-Type","application/json").and()
			.body(jsoninputdata).
		when()
			.post("/posts").
		then()
			.statusCode(201)
			.extract().response();
		
		JSONOutputdata jsonoutputdata = new JSONOutputdata();		
		Gson gson = new GsonBuilder().create();		
		jsonoutputdata = gson.fromJson(response.asString(), JSONOutputdata.class);
		
		Assert.assertEquals(jsonoutputdata.getId(),jsoninputdata.getId());
		Assert.assertEquals(jsonoutputdata.getTitle(),jsoninputdata.getTitle());
		Assert.assertEquals(jsonoutputdata.getAuthor(),jsoninputdata.getAuthor());
		
		System.out.println("The Response : " + response.asString());	
		
	}

}
