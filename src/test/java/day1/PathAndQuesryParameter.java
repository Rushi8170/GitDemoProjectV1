package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQuesryParameter {

	@Test
	public void queryParam() {

		baseURI = "https://reqres.in/api";
		given().header("x-api-key", "free_user_3Cz6eY8FouH9rLcH2h0dAYiFMjG").pathParam("myPath", "users")
				.queryParam("page", 2)

				.when().get("/{myPath}")

				.then().statusCode(200).log().all();

	}
}
