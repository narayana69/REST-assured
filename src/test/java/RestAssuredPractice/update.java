package RestAssuredPractice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class update {
	public void updateuser(ITestContext context) {
		
		int id=(Integer) context.getSuite().getAttribute("User_id");
		

		 Faker faker=new Faker();
		 JSONObject data=new JSONObject();
		 
		 data.put("name",faker.name().fullName());
		 data.put("gender", "female");
		 data.put("email", faker.internet().emailAddress());
		 data.put("status", "active");
		String bearertoken="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
		
		given()
		     .header("Authorization","Bearer "+bearertoken)
		     .contentType(ContentType.JSON)
		     .body(data.toString())
		.when() 
		     .put("https://gorest.co.in/public/v2/users/{id}")
		     .then()
		     .statusCode(200).log().all();
	}
}
