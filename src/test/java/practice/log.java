package practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class log {
	@Test
	public void log() {
		
		given()
		     .contentType(ContentType.JSON)
		     
		.when() 
	          .get("https://www.google.com/")
		.then()
		      .statusCode(200)
		      .log().body()
		      .and().log().cookies()
		    .and().log().headers();
		
		
	}

}
