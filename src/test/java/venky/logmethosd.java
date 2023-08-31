package venky;

import org.testng.annotations.Test;

import practice.log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class logmethosd {
	
	@Test
	public void log_method() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200).
		
		// IT GIVES ALL HEADERS COOKIES AND BODY
	//	log().all();
		
		//ONLY HEADERS
		
		//log().headers();
		//ONLY COOKIES
		//log().cookies();
		
		//ONLY BODY
		log().body();
		
		
		
	}

}
