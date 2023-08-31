package chain;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteuser {
	@Test
	public void testdeleteuser(ITestContext context) {
		String bearertoken="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
	     .header("Authorization","Bearer "+bearertoken)
	     .pathParam("id", id)
	    .when()
	         .delete("https://gorest.co.in/public/v2/users/{id}")
	    .then().statusCode(204).log().all();     
		
	}

}
