package com.restAssured.API;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SoapUIPostRequestRest {
	
	@Test
	public void getSoapUIPostTest() throws Exception {
		
		FileInputStream ip = new FileInputStream("F:\\myproject\\RestAPI\\SOAP Requests\\Sample Request1.xml");
		
		RestAssured.baseURI = "http://currencyconverter.kowabunga.net";
		
		//apache.commons.io jar is required for the IOUtils used below
		
		Response response = 
				given()
					.header("Content-Type","text/xml")
					.and()
					.body(IOUtils.toString(ip,"UTF-8"))
//					.body(ip)
				.when()
					.post("/converter.asmx")
				.then()
					.statusCode(200)
					.and()
					.log().all().extract().response();
		
		XmlPath xml = new XmlPath(response.asString());
		
		String rate = xml.getString("GetConversionRateResult");
		
		System.out.println("The converted rate is : " + rate);
		
		Assert.assertEquals(rate, "75.01513167814258562343086588");
					
							
	}

}
