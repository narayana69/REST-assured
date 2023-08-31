package RestAssuredPractice;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class delete {
	
	
		@Test
		public void deleteuser(ITestContext context) {
			
		int id=(Integer) context.getSuite().getAttribute("user_id");
			given().contentType(ContentType.JSON)
			
			.when()
			  .delete("https://gorest.co.in/public/v2/users/{id}")
			.then().statusCode(204).log().all();  
			
			    
		}

}
