package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getuser {
@Test
public void getuser(ITestContext context) {
	
int id=(Integer) context.getSuite().getAttribute("user_id");
	given().contentType(ContentType.JSON)
	
	.when()
	  .get("https://gorest.co.in/public/v2/users/{id}")
	.then().statusCode(200).log().all();  
	
	    
}
}
