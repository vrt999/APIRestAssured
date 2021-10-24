package StepDefinitions;

import Utilities.RestAssuredExtsnUtil;
import io.cucumber.java.Before;

public class TestInitialize {
	
	@Before
	public void testSetUp() {
		
		System.out.println("The cucumber before Method has run");
		RestAssuredExtsnUtil restAssuredExtsn = new RestAssuredExtsnUtil();
		
	}

}
