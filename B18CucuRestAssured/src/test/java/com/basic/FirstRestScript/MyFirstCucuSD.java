package com.basic.FirstRestScript;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyFirstCucuSD 
// step Def
{
	Response res;
	@Given("^user hit the get request$")
	public void user_hit_the_get_request()
	{
		res = RestAssured.given().get("https://www.google.com/");
		
	}

	
	@Then("^user checks the \"([^\"]*)\" status code$")
	public void user_checks_the_status_code(String stCode)
	{
		//Response res= RestAssured.given().get("https://www.google.com/");
		
		int statusCode= res.getStatusCode();
		
		Assert.assertEquals(stCode,Integer.toString(statusCode));
	}


	@When("^user checks the status code$")
	public void user_checks_the_status_code() throws Throwable {
		Response rest= RestAssured.given().get("https://www.google.com/");
		int stCode= rest.statusCode();
		System.out.println(stCode);
	   	}

}
