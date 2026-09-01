package day1;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class FirstTest {	
	@Test
	public void test2(){
		
		baseURI = "https://reqres.in/api";
		
		given()
		.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		.get("/users?page=2")
		.then()
		.body("data[1].id", equalTo(8))
		.statusCode(200);
	}
	
	@Test
	public void getRequest() {
		
		baseURI = "https://reqres.in/api";
		given()
		.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		
		.when()
		.get("/users?page=2")
		
		.then()
		.body("data[2].first_name", equalTo("Tobias"))
		.body("data.first_name", hasItems("Tobias", "Byron"));
	}
	
	@Test
	public void postRequest() {
			
		JSONObject response = new JSONObject();
		response.put("name", "rushi");
		response.put("job", "pistol");
		
		System.out.println(response);
		
		
		baseURI = "https://reqres.in/api";
		
		given()
		.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(response.toString())
		
		.when()
		.post("/users")
		
		.then()
		.statusCode(201)
		.log().all();
		
	}
}
