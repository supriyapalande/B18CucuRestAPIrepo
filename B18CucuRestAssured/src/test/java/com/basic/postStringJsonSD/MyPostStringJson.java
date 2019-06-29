package com.basic.postStringJsonSD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.Assert;

public class MyPostStringJson {
	 
	Response resp ;
	
	@Given("^user hit the post request from String$")
	public void user_hit_the_post_request_with_String() throws IOException{
		
		
		
		resp = RestAssured.given().accept(ContentType.JSON).relaxedHTTPSValidation().
				when().body("{    \"name\": \"Tom\",    \"job\":\"Actor\"}").post("https://reqres.in/api/users");
//		resp.then().log().all();
//		resp.then().log().status();
		System.out.println("====="+resp.asString());
		
		int statusCode= resp.getStatusCode();
		Assert.assertEquals(201, statusCode);
		
	}
	
	@Then("user validate the id is not null")
	public void user_validate_the_id_is_not_null(){
		
		//Check id is not null(matchers)
		resp.then().assertThat().body("id", notNullValue());
		
		//check id is greater than zero(Jason)
		String idValue = resp.getBody().jsonPath().get("id");
		int idInt = Integer.parseInt(idValue);
		Assert.assertTrue(idInt > 0);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
 