package RestAssuredPractice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import venky.pojoclass;

public class seriadesre {
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
		String jsondata=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
}@Test
	public void jsontopojo() throws JsonProcessingException {
	//creating java object using pojo class
	String json="{\r\n"
			+ "  \"name\" : \"venky\",\r\n"
			+ "  \"age\" : 24,\r\n"
			+ "  \"course\" : [ \"c\", \"c++\" ],\r\n"
			+ "  \"location\" : \"kanigiri\"\r\n"
			+ "}";
	ObjectMapper objmap=new ObjectMapper();
	pojoclass pojodata=objmap.readValue(json, pojoclass.class);
	System.out.println("age ;"+pojodata.getAge());
	System.out.println("name ;"+pojodata.getName());
	System.out.println("location ;"+pojodata.getLocation());
	System.out.println("age ;"+pojodata.getCourse());
}}