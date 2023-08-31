package venky;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class QueryAndpathParameters {
	//https://reqres.in/api/users?page=2
	@Test
	
	public void path_query_parameters() {
		
		given()
		
		.pathParam("mypath", "users")
		.queryParam("page", "2")
		.queryParam("id", "5")
		
		.when()
		   .get("https://reqres.in/api/{mypath}")
		.then()
		   .statusCode(200).log().all();
		
	}

}
