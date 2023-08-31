package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import groovy.transform.stc.POJO;
import io.restassured.http.ContentType;

public class serializationdeserialization {
	@Test
	public void pojo2json() throws JsonProcessingException {
		
		
		//creating object using pojoclass
		
		pojoclass pojo=new pojoclass();
		pojo.setName("venky");
		pojo.setLast_name("kulluri");
		String cr[]= {"dta","venky"};
		pojo.setCourse(cr);
		//converting pojo data to json
		ObjectMapper objmap=new ObjectMapper();
		
	String jsonobj=	objmap.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		
		System.out.println(jsonobj);
		
		
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
       . when()
             .post("https://reqres.in/api/users")
             
	
        .then().statusCode(201) 
        .body("name", equalTo("venky"))
        .body("last_name", equalTo("kulluri"))
        .body("course[1]", equalTo("venky"))
       .log().body();
		
	}
	@Test
	
	public void convertjson2pojo() throws JsonMappingException, JsonProcessingException {
		
		String jsonobj="{\r\n"
				+ "  \"name\" : \"venky\",\r\n"
				+ "  \"last_name\" : \"kulluri\",\r\n"
				+ "  \"course\" : [ \"dta\", \"venky\" ]\r\n"
				+ "}";
		
		//converting json data to pojo
		ObjectMapper pojodat=new ObjectMapper();
	pojoclass poj=	pojodat.readValue(jsonobj,pojoclass.class);
	
	
	System.out.println("Name:  "+poj.getName());
	System.out.println("last_name:  "+poj.getLast_name());
	System.out.println("course 1  :  "+poj.getCourse()[0]);
	System.out.println("course 2  :  "+poj.getCourse()[1]);

	
	
	
	}
}
