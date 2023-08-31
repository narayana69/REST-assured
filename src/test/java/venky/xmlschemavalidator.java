package venky;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
public class xmlschemavalidator {
	
	@Test
	public void jsonschemavalidator() {
		
		given()
		
		.when()
		     .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		     
		.then()
		    .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("venky.xsd"));
	}

	

}
