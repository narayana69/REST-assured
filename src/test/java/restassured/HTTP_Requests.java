package restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HTTP_Requests {
	int id;
	@Test(priority = 1)
	public void get_users_method() {
			
		given()
		      
		
	    .when()
	         .get("https://reqres.in/api/users?page=2")
	    
	    .then()
	         .statusCode(200)
	         .body("page", equalTo(2))
	         .log().all();
		
	}@Test(priority = 2)
	
	public void create_users_postmethod() {
			HashMap mp=new HashMap();
			mp.put("name", "venky");
			mp.put("last_name", "kulluri");
	id=	given()
		.contentType("application/json")
		.body(mp)
	    .when()
	         .post("https://reqres.in/api/users")
	         .jsonPath().getInt("id");
	    
//	    .then()
//	         .statusCode(201)
//	         
//	         .log().all();
		
	}@Test(priority = 3, dependsOnMethods = {"create_users_postmethod"})
	public void update_users_putmethod() {
		HashMap mp=new HashMap();
		mp.put("name", "narayana");
		mp.put("last_name", "rowdy");
	given()
	.contentType("application/json")
	.body(mp)
    .when()
         .put("https://reqres.in/api/users/"+id)
         
    
    .then()
         .statusCode(200)
         
         .log().all();
	
}@Test(priority = 4)
	
	public void delete_user_method() {
	
	when()
	    .delete("https://reqres.in/api/users/"+id)
	    .then()
	    .statusCode(204)
	    .log().all();
	
	
	
}

}
