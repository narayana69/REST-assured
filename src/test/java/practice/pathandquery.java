package practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class pathandquery {
@Test
public void pathandquerypara() {
	
	given()
	    .pathParam("mypath","users")
	    .queryParam("id", 7)
	    .queryParam("page", 1)
	    
	.when()
	     .get("https://reqres.in/api/{mypath}")
	     
	.then().statusCode(200).log().all();
	

}
}
