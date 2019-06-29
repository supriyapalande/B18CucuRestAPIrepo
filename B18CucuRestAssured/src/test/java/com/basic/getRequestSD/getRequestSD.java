package com.basic.getRequestSD;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class getRequestSD {
	Response resp;
	
	@Given("^user start the rest assured test$")
	public void user_start_the_rest_assured_test() throws Throwable 
	{
		System.out.println("Starting of the GET request");
	 }
	
	@When("^user hit the get request$")
	public void user_hit_the_get_request()
	{
		//reponse resp
		resp = RestAssured.given().relaxedHTTPSValidation().when().get("https://ergast.com/api/f1/2017/circuits.json");
	
	//print response in string 
	
	String respString = resp.asString();
	System.out.println(respString);
	}
	
	
	@Then("^user checks the status code$")
	public void user_checks_the_status_code() throws Throwable {
	    
		int expStatusCode= 200;
	int statusCode= resp.getStatusCode();
	Assert.assertTrue(expStatusCode==statusCode);
	}
	
	
	@Then("^user check the limit$")
	public void user_check_the_limit() throws Throwable {
		
		String limitValue = resp.getBody().jsonPath().getString("MRData.limit");
		Assert.assertEquals("30", limitValue);
	  
	}
	
}

	