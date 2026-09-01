package july3;

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

public class DiffWaysToCreatePostRequest {

	// 1. POST request body using HashMap
	//@Test
	void testPOSTusingHAshMAp() {

		HashMap data = new HashMap();

		data.put("name", "jarvis");
		data.put("phone", "5869745213");

		String courseArr[] = { "c", "c++" };
		data.put("courses", courseArr);

		given().contentType("application/json").body(data).when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("jarvis")).body("phone", equalTo("5869745213"))
				.body("courses[0]", equalTo("c")).body("courses[1]", equalTo("c++"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

	// 2. using org.json
	//@Test(priority = 1)
	void testPOSTusingJsonLibrary() {

		JSONObject data = new JSONObject();
		data.put("name", "marvel");
		data.put("phone", "5869745213");

		String courseArr[] = { "c", "c++" };
		data.put("courses", courseArr);

		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("marvel")).body("phone", equalTo("5869745213"))
				.body("courses[0]", equalTo("c")).body("courses[1]", equalTo("c++"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}
	
	//3. using POJO class
	
	//@Test(priority = 1)
	void testPOSTusingPOJO() {

		POSTRequeestwithPOJO data = new POSTRequeestwithPOJO();
		data.setName("jarvis");
		data.setPhone("5869745213");
		String coursesArr[] = {"c", "c++"};
		data.setCourses(coursesArr);

		given().contentType("application/json").body(data).when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("jarvis")).body("phone", equalTo("5869745213"))
				.body("courses[0]", equalTo("c")).body("courses[1]", equalTo("c++"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}
	
	//4. using external json
	@Test
	void testPOSTusingExternalJSON() throws FileNotFoundException {

		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);

		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("rushi")).body("phone", equalTo("6494586898"))
				.body("courses[0]", equalTo("C")).body("courses[1]", equalTo("Playwright"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}
	
	@Test(priority = 2,enabled = true)
	void deleteRequest() {
		given()

				.when().delete("http://localhost:3000/students/5").then().log().all();
	}

	@Test(priority = 3)
	void getData() {
		given().when().get("http://localhost:3000/students").then().log().all();
	}
}
