package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class xmalschemavalidator {
@Test
public void xmlvalidator() {
	
	given()
	
	
	.when()
	  .get("http://restapi.adequateshop.com/api/Traveler?page=1")
	  
	.then()
	     .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("venky.xsd"));
}
}
