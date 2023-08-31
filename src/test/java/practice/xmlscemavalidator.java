package practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class xmlscemavalidator {
	@Test
	public void jsonschema() {
		
		given()
		     
		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("kv.xsd"));
		
		
		
	}
}
