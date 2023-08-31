package venky;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class updateuser {
	@Test
	public void test_createuser(ITestContext context) {
		 Faker faker=new Faker();
		 JSONObject data=new JSONObject();
		 
		 data.put("name",faker.name().fullName());
		 data.put("gender", "female");
		 data.put("email", faker.internet().emailAddress());
		 data.put("status", "active");
		String bearertoken="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
		
	int id=(Integer) context.getAttribute("user_id");
			
			given()
		     .header("Authorization","Bearer "+bearertoken)
		     .contentType(ContentType.JSON)
		     .body(data.toString())
		     .pathParam("id", id)
		.when() 
		     .put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		   .statusCode(200)
		   .log().all();
		
		
	}

		
}
