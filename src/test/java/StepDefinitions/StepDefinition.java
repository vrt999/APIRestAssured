package StepDefinitions;

import java.net.URISyntaxException;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.hasItem;
import Utilities.RestAssuredExtsnUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinition {
	
	private static ResponseOptions<Response> response;
	
    @Given("I perform GET operation for {string}")
    public void i_perform_GET_operation_for(String url) throws URISyntaxException {
    	response = RestAssuredExtsnUtil.getOps(url);
    	
    	
    }


    @Then("I should see the author name as {string}")
    public void i_should_see_the_author_name_as(String authorName) {
    	assertThat(response.getBody().jsonPath().getString("author"),(Matcher)hasItem(authorName));

    }

    @Then("I should see the author names")
    public void i_should_see_the_author_names() {
        BDDStyleMethod.performContainsCollection();

    }
    
    @Then("I should see verify GET parameter")
    public void i_should_see_verify_GET_parameter() {
    	BDDStyleMethod.performPathParam();
    	BDDStyleMethod.performQueryParam();

    	}
    	

}
