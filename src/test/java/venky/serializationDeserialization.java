package venky;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class serializationDeserialization {
	@Test
	public void pojoTojson() throws JsonProcessingException {
		//creating java object using pojo class
		pojoclass data= new pojoclass();
		data.setAge(24);
		data.setLocation("kanigiri");
		data.setName("venky");
		String coursearr[]= {"c","c++"};
		data.setCourse(coursearr);
		// serialization convert pojo to json 
		
		ObjectMapper objmap=new ObjectMapper();
	String jsondata=	objmap.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	System.out.println(jsondata);
	}
	@Test
	
	public void jsonTopojo() throws JsonMappingException, JsonProcessingException {
		
		String jsondata="{\r\n"
				+ "  \"name\" : \"venky\",\r\n"
				+ "  \"age\" : 24,\r\n"
				+ "  \"course\" : [ \"c\", \"c++\" ],\r\n"
				+ "  \"location\" : \"kanigiri\"\r\n"
				+ "}";
		
		ObjectMapper objm=new ObjectMapper();
		
	pojoclass pojodata=	objm.readValue(jsondata, pojoclass.class);
	
	System.out.println("Age :"+pojodata.getAge());
	System.out.println("Name :"+pojodata.getName());
	System.out.println("location :"+pojodata.getLocation());
	System.out.println(" course:"+pojodata.getCourse()[0]);
	System.out.println(" course:"+pojodata.getCourse()[1]);
	}
	
	

}
