package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
public class createuser {
	@Test
	public void createuser(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		String bearertoken="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
		int id=	given()
			     .header("Authorization","Bearer "+bearertoken)
			     .contentType(ContentType.JSON)
			     .body(data.toString())
			.when() 
			     .post("https://gorest.co.in/public/v2/users")
			     .jsonPath().getInt("id");  
		System.out.println("genarate id:  "+id);
			context.getSuite().setAttribute("user_id", id);
	}

}
