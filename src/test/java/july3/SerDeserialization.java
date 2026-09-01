package july3;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerDeserialization {

	@Test
	public void seri() throws JsonProcessingException {
		POSTRequeestwithPOJO pojo = new POSTRequeestwithPOJO();
		pojo.setName("abc");
		pojo.setPhone("9584672135");
		
		ObjectMapper jo = new ObjectMapper();
		
		String stu = jo.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		
		System.out.println(stu);
		
	}
	@Test
	public void dseri() throws JsonProcessingException {
		String stu = "{\r\n"
				+ "  \"name\" : \"rushi\",\r\n"
				+ "  \"phone\" : \"5697464684\",\r\n"
				+ "  \"courses\" : null\r\n"
				+ "}";
		
		ObjectMapper om = new ObjectMapper();
		POSTRequeestwithPOJO pojo = om.readValue(stu, POSTRequeestwithPOJO.class);
		System.out.println(pojo.getName());
		System.out.println(pojo.getPhone());
	}
}
