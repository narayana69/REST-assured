package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class Httprequests {
	int id;
	@Test(priority = 0)
	
	public void get_user() {
		
         given()
         
        . when()
              .get("https://reqres.in/api/users?page=2")
              
        .then()
        .statusCode(200)
        .body("page", equalTo(2)).log().all();
	}
	@Test(priority = 1)
	public void create_user() {
		HashMap data= new HashMap();
		data.put("name", "venky");
		data.put("house", "kulluri");
	id=	given()
		.contentType(ContentType.JSON)
		.body(data)
       . when()
             .post("https://reqres.in/api/users")
             .jsonPath().getInt("id");
	
             
//       .then()
//       .statusCode(201)
//       .log().all();
	}  
	@Test(priority = 2)
	public void put_user() {
		HashMap data= new HashMap();
		data.put("name", "venky");
		data.put("house", "kulluri");
		given()
		.contentType(ContentType.JSON)
		.body(data)
       . when()
             .put("https://reqres.in/api/users/"+id)
     
       .then()
       .statusCode(200)
       .log().all();
	}  
	@Test(priority = 4)
	public void delete_user() {
        
		 when()
        .delete("https://reqres.in/api/users/"+id)
        

        
  .then()
  .statusCode(204)
  .log().all();
	
	
	
	
	
	
	}	
	

}
