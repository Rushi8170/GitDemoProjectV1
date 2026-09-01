package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {

	int id;
	
	@Test(priority = 1)
	void getUsers() {
		given()
			.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2));
			//.log().all();
	}
	
	@Test(priority = 2)
	void createUser() {
		HashMap data = new HashMap();
		data.put("name", "Rushikesh");
		data.put("job", "Sr Tester");
		
		id=given()
		 	.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		    
		System.out.println(id);	
		//.then()
		//	.statusCode(200)
		//	.log().all();
	}
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Rushikesh");
		data.put("job", "Tester");
		
		given()
		 	.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/users/"+id)		    
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 4, dependsOnMethods = {})
	void deleteUser() {
		given()
	 	.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		
	.when()
		.delete("https://reqres.in/api/users/"+id)		    
		
	.then()
		.statusCode(204)
		.log().all();
	}

}
