package StepDefinitions;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class BDDStyleMethod {

    public static void simpleGET(String postnumber) {
        given().contentType(ContentType.JSON).
//                when().get(String.format("http://localhost:3000/posts/%s",postnumber)).
        		when().get("http://localhost:3000/posts/" + postnumber).
                then().body("author",is("typicode"));
        
        System.out.println("The Author validation is successful");
    }

    public static void performContainsCollection() {
        given()
                .contentType(ContentType.JSON).
        when()
                .get("http://localhost:3000/posts").
        then()
                .body("author",containsInAnyOrder("typicode",null,"typicode364")).statusCode(200);
    }

	public static void performPathParam() {
		given().
			contentType(ContentType.JSON).
		with().
			pathParam("post", 1).
		when().
			get("http://localhost:3000/posts/{post}").
		then().
			body("author",containsString("typicode"));
		System.out.println("The Path param validation successful");
		
	}
	
	public static void performQueryParam() {
		given().
			contentType(ContentType.JSON).
		with().
			queryParam("id", 1).
		when().
			get("http://localhost:3000/posts/").
		then().
			body("author",hasItem("typicode"));
		System.out.println("The Query param validation successful");
		
	}


}
