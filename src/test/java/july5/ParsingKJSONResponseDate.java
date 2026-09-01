package july5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingKJSONResponseDate {
	
	@Test(priority = 1)
	void testJSONResponse() {
		
		//Approach 1
		
		/*given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/store")
		.then()
		.statusCode(200)
		.log().all()
		.body("[3].title", equalTo("The Lord of the Rings"));*/
		
		
		//Approach 2
		
		Response res = 
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/store");
		
		//Assert.assertEquals(res.getStatusCode(), 200); 
		
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String bookArray = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookArray);
		}
	}
}
