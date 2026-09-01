package test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import july3.POSTRequeestwithPOJO;

public class pract1 {
	
	int id;
	@Test
	public void getFirst() {
		
		JSONObject data = new JSONObject();
		data.put("name", "rushikesh");
		data.put("designation", "sr test engg");
		
		id = given()
		.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		//.then()
		//.statusCode(200);
		
		System.out.println(id);
		
	}
	
	@Test
	public void get1() {
		
		JSONObject data = new JSONObject();
		data.put("name", "rushikesh");
		data.put("designation", "test lead");
		
		given()
		.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		.contentType("application/json")
		.body(data.toString())
		.when().
		put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200);
	}
	
	
}
