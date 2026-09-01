package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;


public class Headers {
	
	@Test
	public void testHeaders() {
			given()

			.when().get("https://www.google.com")
	
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip")
				.log().all();
			
	}
	
	@Test
	public void getHeaders() {
		
		Response res = given()
		
		.when()
			.get("https://www.google.com");
		
		
		
		for(Header h : res.getHeaders())
		{
			System.out.println(h.getName()+"		"+h.getValue());
		}
		
	}
}

