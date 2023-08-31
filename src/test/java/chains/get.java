package chains;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class get {
	
	@Test
	public void get(ITestContext context) {
		String token="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
		
		int id=(Integer)context.getAttribute("user");
				given()
			      .headers("Authorization","Bearer "+token)
			      .contentType(ContentType.JSON)
			      .pathParam("id",id)
		.when()	
		      .post("https://gorest.co.in/public/v2/users/{di}")
		.then().statusCode(200).log().all();      
		
	}

}
