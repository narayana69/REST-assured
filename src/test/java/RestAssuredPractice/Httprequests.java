package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class Httprequests {
	int id;
@Test
public void get() {
	
	given()
	     
	
	.when()
	     .get("https://reqres.in/api/users?page=2")
	     
	
	.then()
	    .statusCode(200)
	    .body("data[1].id", equalTo(8))
	    .body("data.id", hasItems(7,8,9,10,11,12))
	    .log().all();
	
	
}
@Test
public void post() {
	
	
	HashMap data=new HashMap();
	data.put("name", "venky");
	data.put("age", 24);
	data.put("location", "nellore");
id=	given()
	     .contentType(ContentType.JSON)
	     .body(data)
	
	.when()
	     .post("https://reqres.in/api/users")
	     .jsonPath().getInt("id");
	     
//	
//	.then()
//	    .statusCode(201)
//	    
//	    .log().all();
}
@Test
public void put() {
	
	
	HashMap data=new HashMap();
	data.put("name", "narayana");
	data.put("age", 24);
	data.put("location", "nellore");
	String coursear[]= {"c","c++"};
	data.put("course", coursear);
	given()
	     .contentType(ContentType.JSON)
	     .body(data)
	
	.when()
	     .put("https://reqres.in/api/users/"+id)
	     
	
	.then()
	    .statusCode(200)
	    .body("name", equalTo("narayana"))
	    .body("course[0]", equalTo("c"))
	    .body("course",hasItems("c","c++"))
	    .log().all();
}
@Test
public void delete() {
	
	when()
    .delete("https://reqres.in/api/users/"+id)
    

.then()
   .statusCode(204);
}
}
