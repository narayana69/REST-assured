package venky;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HttpRequests {
	int id;
	@Test(priority = 1)
	public void getuser() {
		
		given()
		
		
		.when()
		     .get("https://reqres.in/api/users?page=2")
		
		
		.then()
		     .statusCode(200)
		     .body("data[1].id", equalTo(8))
		     .body("data.id", hasItems(7,8,9,10)).log().body();
		
	}
	@Test(priority = 2)
	public void createuser() {
		HashMap data=new HashMap();
		data.put("name", "venky");
		data.put("age", 24);
	 id=	given()
		    .contentType(ContentType.JSON)
		    .body(data)
		
		.when()
		     .post("https://reqres.in/api/users")
		     .jsonPath().getInt("id");
		
		
//		.then()
//		     .statusCode(201)
//		    
//		    .log().body();
		
	}
	@Test(priority = 3,dependsOnMethods = {"createuser"})
	public void updateuser() {
		HashMap data=new HashMap();
		data.put("name", "narayana");
		data.put("age", 24);
		data.put("location", "kanigiri");
	 	given()
		    .contentType(ContentType.JSON)
		    .body(data)
		
		.when()
		     .put("https://reqres.in/api/users/"+id)
		    
		
		
		.then()
		     .statusCode(200)
		    
		    .log().body();
		
	}
	@Test
	public void deleteuser() {
		
	 	given()
		   		
		.when()
		     .delete("https://reqres.in/api/users/"+id)
		    
		
		
		.then()
		     .statusCode(204)
		    
		    .log().body();
		
	}

}
