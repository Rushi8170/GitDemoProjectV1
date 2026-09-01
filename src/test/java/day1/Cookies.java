package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	@Test
	public void testCookies() {
		//baseURI = "https://reqres.in/api";
		
		Response res = given()
			.header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG")
		
		.when()
			.get("https://www.google.com");
			
		Map<String, String> cookies_values = res.getCookies();
		
		for(String k : cookies_values.keySet())
		{
			String cookie_values = res.getCookie(k);
			System.out.println(k+"		"+cookie_values);
		}
	}
}
