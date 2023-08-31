

package Apractice1;
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

import io.restassured.http.ContentType;

public class differentwayspost {
	@Test
	public void hashmap() {
		
			
			HashMap data=new HashMap();
			data.put("name","rowdy");
			data.put("location", "benglore");
			data.put("age", 24);
			String coursearr[]= {"java","javascript"};
			data.put("course", coursearr);
           	given()
		      .contentType(ContentType.JSON)
		      .body(data)
		
		.when()
		    .post("https://reqres.in/api/users")
		   
		
		.then()
		      .statusCode(201)
		      .body("name", equalTo("rowdy"))
		      .body("course",hasItems("java","javascript"))
		      .body("location",equalTo("benglore"))
		      .log().all();
	}
	@Test
	public void json() {
		
			
			JSONObject data=new JSONObject();
			data.put("name","rowdy");
			data.put("location", "benglore");
			data.put("age", 24);
			String coursearr[]= {"java","javascript"};
			data.put("course", coursearr);
           	given()
		      .contentType(ContentType.JSON)
		      .body(data.toString())
		
		.when()
		    .post("https://reqres.in/api/users")
		   
		
		.then()
		      .statusCode(201)
		      .body("name", equalTo("rowdy"))
		      .body("course",hasItems("java","javascript"))
		      .body("location",equalTo("benglore"))
		      .log().all();
	}
	@Test
	public void pojo() {
		pojo data=new pojo();
		data.setAge(24);
		data.setLocation("kanigiri");
		String cousear[]= {"java","javascript"};
		data.setCourse(cousear);
		data.setName("venky");
	 	given()
	      .contentType(ContentType.JSON)
	      .body(data)
	
	.when()
	    .post("https://reqres.in/api/users")
	   
	
	.then()
	      .statusCode(201)
	      .body("name", equalTo("venky"))
	      .body("course",hasItems("java","javascript"))
	      .body("location",equalTo("kanigiri"))
	      .log().all();
		
	}
	@Test
	public void externalfile() throws FileNotFoundException {
		File file=new File(".\\body.json");
		FileReader ff=new FileReader(file);
		JSONTokener js=new JSONTokener(ff);
		JSONObject data=new JSONObject(js);
		given()
	      .contentType(ContentType.JSON)
	      .body(data.toString())
	
	.when()
	    .post("https://reqres.in/api/users")
	   
	
	.then()
	      .statusCode(201)
	      .body("name", equalTo("venky"))
	      .body("course",hasItems("c","c++"))
	      .body("location",equalTo("kanigiri"))
	      .log().all();
		
		
		
		
	}

}
