package venky;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class ways_to_create_postRequest {
	@Test
	
	public void hashmap() {
		HashMap data=new HashMap();
		data.put("name", "venky");
		data.put("age", 24);
		data.put("location", "kanigiri");
		String courarr[]= {"c","c++"};
		data.put("course", courarr);
		
		
		given()
		      .contentType(ContentType.JSON)
		      .body(data)
		
		
		.when()
		     .post("  http://localhost:3000/users")
		
		
		.then()
		  .statusCode(201)
		  .body("name", equalTo("venky"))
		  .body("age", equalTo(24))
		  .body("location", equalTo("kanigiri"))
		  .body("course[0]", equalTo("c"))
          .body("course", hasItems("c","c++"))		  
		  .header("content-type", "application/json; charset=utf-8")
		  
		  .log().all();
	
	}
	@Test
	
	public void jsonobject() {
		JSONObject data=new JSONObject();
		data.put("name", "venky");
		data.put("age", 24);
		data.put("location", "kanigiri");
		String courarr[]= {"c","c++"};
		data.put("course", courarr);
		
		
		given()
		      .contentType(ContentType.JSON)
		      .body(data.toString())
		
		
		.when()
		     .post("  http://localhost:3000/users")
		
		
		.then()
		  .statusCode(201)
		  .body("name", equalTo("venky"))
		  .body("age", equalTo(24))
		  .body("location", equalTo("kanigiri"))
		  .body("course[0]", equalTo("c"))
          .body("course", hasItems("c","c++"))		  
		  .header("content-type", "application/json; charset=utf-8")
		  
		  .log().all();
	
	}
@Test
	
	public void pojoclass() {
		pojoclass data= new pojoclass();
		data.setAge(24);
		data.setLocation("kanigiri");
		data.setName("venky");
		String coursearr[]= {"c","c++"};
		data.setCourse(coursearr);
		
		
		given()
		      .contentType(ContentType.JSON)
		      .body(data)
		
		
		.when()
		     .post("  http://localhost:3000/users")
		
		
		.then()
		  .statusCode(201)
		  .body("name", equalTo("venky"))
		  .body("age", equalTo(24))
		  .body("location", equalTo("kanigiri"))
		  .body("course[0]", equalTo("c"))
          .body("course", hasItems("c","c++"))		  
		  .header("content-type", "application/json; charset=utf-8")
		  
		  .log().all();
	
	}
@Test

public void extenalfiles() throws FileNotFoundException {
	File file=new File(".\\body.json");
	FileReader js=new FileReader(file);
	JSONTokener j=new JSONTokener(js);
	JSONObject data=new JSONObject(j);
	given()
    .contentType(ContentType.JSON)
    .body(data.toString())


.when()
   .post("  http://localhost:3000/users")


.then()
.statusCode(201)
.body("name", equalTo("venky"))
.body("age", equalTo(24))
.body("location", equalTo("kanigiri"))
.body("course[0]", equalTo("c"))
.body("course", hasItems("c","c++"))		  
.header("content-type", "application/json; charset=utf-8")

.log().all();

}

	@Test
	public void deleteuser() {
		
	 	given()
		   		
		.when()
		     .delete("http://localhost:3000/users/17")
		    
		
		
		.then()
		     .statusCode(200)
		    
		    .log().body();
	 	
		
	}
	

}
