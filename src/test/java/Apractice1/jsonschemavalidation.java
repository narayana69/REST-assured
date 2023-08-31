package Apractice1;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
public class jsonschemavalidation {
@Test
public void jsonschema() {
given()
	
	
	.when()
	    .get("http://localhost:3000/users")
	.then()
	     .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("venky.json"))
	     .statusCode(200).log().body();

}
}
