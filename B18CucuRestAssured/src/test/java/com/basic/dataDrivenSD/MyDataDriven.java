package com.basic.dataDrivenSD;

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

public class MyDataDriven {
	 
	Response resp ;
	String data = ""; 
	JSONObject object;
	String newJsonStr;
	
	@Given("^user update name with \"([^\"]*)\" name$")
	public void user_update_name_with_name (String username) throws IOException{
		
		//Read data from file
	   // data = new String(Files.readAllBytes(Paths.get("D:\\IBM\\workspace\\CucuRestAssured\\src\\test\\java\\com\\basic\\dataDrivenSD\\user.json"))); 
		data = new String(Files.readAllBytes(Paths.get("C:\\Users\\Admin\\workspace\\B18CucuRestAssured\\src\\test\\java\\com\\basic\\dataDrivenSD\\user.json"))); 
		System.out.println("json in String ==== " +data);
	    
	    //Update the data
	    object=new JSONObject(data);
	    object.put("name", username);
	   
	}
	
	@Given("^user update job with \"([^\"]*)\" name$")
	public void user_hit_the_post_request_with_json_data(String job) throws IOException{
		
		object.put("job", job);
	    newJsonStr = object.toString();
	    System.out.println("json in String ==== " +newJsonStr);
	}
	
	
	@Then("^user post the request$")
	public void user_post_the_request(){
		 //Do POST request
	    resp = RestAssured.given().accept(ContentType.JSON).relaxedHTTPSValidation().
				when().body(newJsonStr).post("https://reqres.in/api/users");
	}
	
	
	
	@Then("user validate the id is not null")
	public void user_validate_the_id_is_not_null(){
		
		//Check id is not null
		resp.then().assertThat().body("id", notNullValue());
		
		//check id is greater than zero
		String idValue = resp.getBody().jsonPath().get("id");
		int idInt = Integer.parseInt(idValue);
		Assert.assertTrue(idInt > 0);
		
	}

}
 