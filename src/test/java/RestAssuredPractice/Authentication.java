package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Authentication {
	@Test
	public void basic() {
	given()
	    .auth().basic("postman", "password")
	  .when()
	     .get("http://postman-echo.com/basic-auth")
	     .then().log().all();
		
	}
	@Test
		public void digest() {
		given()
		    .auth().digest("postman", "password")
		  .when()
		     .get("http://postman-echo.com/digest-auth")
		     .then().log().all();
			
		}
	
		@Test
		public void preemative() {
		given()
		    .auth().preemptive()
		    .basic("postman", "password")
		  .when()
		     .get("http://postman-echo.com/basic-auth")
		     .then().log().all();
			
		}
		
			@Test
			public void auth1() {
			given()
			    .auth().oauth("consumerkey", "consumersecrate","accessToken","Tokensecrate")
			  .when()
			     .get("url")
			     .then().log().all();
				
			}
			@Test
			public void auth2() {
				String bearertoken="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";
			given()
			    .auth().oauth2(bearertoken)
			  .when()
			     .get("https://api.github.com/user/repos")
			     .then().log().all();
				
			}
			@Test
			public void Apikey() {
				
			given()
			    .queryParam("rowdy", "5f54818619d1308d478a309e6aceb93c")
			  .when()
			     .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=London&units=metric&cnt=7")
			     .then().log().all();
				
			}
			
			
		
}
