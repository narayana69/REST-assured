package Apractice1;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
public class xmlschemavalidation {
@Test
public void xmlschema() {
given()
	
	
	.when()
	    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
	.then()
	     .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("venky.xsd"))
	     .statusCode(200).log().body();

}
}
