package chains;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class create {
	@Test
	public void create(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String token="59da9d3a023512d7c99ffdf3475d8722c84477180d826f528516d4622f723c2f";
		
	int di=	given()
		      .headers("Authorization","Bearer "+token)
		      .contentType(ContentType.JSON)
		      .body(data.toString())
	.when()	
	      .post("https://gorest.co.in/public/v2/users")
	      .jsonPath().getInt("id");
	System.out.println(di);
	context.setAttribute("user", di);
	
		
	}

}
