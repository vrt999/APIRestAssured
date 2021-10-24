package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtsnUtil {
	
	public static RequestSpecification request;
	
	public RestAssuredExtsnUtil() {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();		
		builder.setBaseUri("http://localhost:3000");
		builder.setContentType(ContentType.JSON);
		RequestSpecification reqspec = builder.build();		
		request = given().spec(reqspec);	 
//		request = builder.build();	assign to request like this seems to be an existing bug in RestAssured got to know from GITHUB
		
	}
	
	public static void getOpswithParams(String url,Map<String,String> pathparams) throws URISyntaxException {
		
		request.pathParams(pathparams);
		request.get(url);
//		request.get(new URI(url));
		
	}
	
	public static ResponseOptions<Response> getOps(String url) throws URISyntaxException {
		
		return request.get(new URI(url));
		
	}
	
	

}
