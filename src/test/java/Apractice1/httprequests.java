package Apractice1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class httprequests {
	int id;
	@Test(priority = 1)
	
	public void getmethod() {
	given()
	
	
	.when()
	    .get("https://reqres.in/api/users?page=2")
	
	.then()
	      .statusCode(200)
	      .body("data[2].id", equalTo(9))
	      .body("data.id",hasItems(7,8,9,10))
	      .log().all();
	
	}@Test(priority = 2)
	
	public void postmethod() {
		
		HashMap data=new HashMap();
		data.put("name","rowdy");
		data.put("location", "");
		data.put("age", "24");
		String coursearr[]= {"java","javascript"};
		data.put("course", coursearr);
  id=	given()
	      .contentType(ContentType.JSON)
	      .body(data)
	
	.when()
	    .post("https://reqres.in/api/users")
	    .jsonPath().getInt("id");
	
//	.then()
//	      .statusCode(201)
//	      .body("name", equalTo("rowdy"))
//	      .body("course",hasItems("java","javascript"))
//	      .body("location",equalTo("benglore"))
//	      .log().all();
	
	}@Test(priority = 3)
	
	public void putmethod() {
		
		HashMap data=new HashMap();
		data.put("name","rowdy");
		data.put("location", "nvm");
		data.put("age", "24");
		String coursearr[]= {"java","javascript"};
		data.put("course", coursearr);
 	given()
	      .contentType(ContentType.JSON)
	      .body(data)
	
	.when()
	    .put("https://reqres.in/api/users/"+id)
	    
	
	.then()
	      .statusCode(200)
	      .body("name", equalTo("rowdy"))
	      .body("course",hasItems("java","javascript"))
	      .body("location",equalTo("nvm"))
	      .log().all();
	
	}
	@Test(priority = 4)
	public void delete() {
		when()
		.delete("https://reqres.in/api/users/"+id)
		.then().statusCode(204).log().all();
			
		
	}
	
	

}
