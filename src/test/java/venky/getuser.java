package venky;

import static io.restassured.RestAssured.given;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getuser {
	@Test
	public void testgetuser(ITestContext context) {
		int id=(Integer) context.getAttribute("user_id");
		String bearertoken="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
	
	given()
    .header("Authorization","Bearer "+bearertoken)
    .pathParam("id", id)
.when() 
    .get("https://gorest.co.in/public/v2/users/{id}")
 .then().statusCode(200).log().all();   
	}
}
