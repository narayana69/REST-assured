package venky;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class jsonschemavalidator {
	
	@Test
	public void jsonschemavalidator() {
		
		given()
		
		.when()
		     .get("http://localhost:3000/users")
		     
		.then()
		    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("venky.json"));
	}

}
