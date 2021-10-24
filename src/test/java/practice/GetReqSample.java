package practice;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class GetReqSample {
	
	@Test
	public void GetSample() {
		RequestSpecBuilder builder = new RequestSpecBuilder();		
		builder.setContentType(ContentType.JSON);
		RequestSpecification request = given().spec(builder.build());
		
		Response response = request.get("http://localhost:3000/posts/1");
		response.getStatusCode();
		
		System.out.println("The response: " + response.asString());
		
		System.out.println("The ID: " + response.jsonPath().getInt("id"));
		System.out.println("The title: " + response.jsonPath().getString("title"));
		System.out.println("The author: " + response.jsonPath().getString("author"));
		
		System.out.println("The Matcher output is: " + Matchers.equalTo(response.jsonPath().getString("id")));
		
		
		
		
		
		}

}
