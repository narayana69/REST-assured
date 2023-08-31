package practice;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Authentications {
	
	@Test(priority = 1)
	public void basicaauth() {
		
      given()
          .auth().basic("postman", "password")
      
      .when()
           .get("https://postman-echo.com/basic-auth")
      .then()
		   .statusCode(200)
           .body("authenticated", equalTo(true)).log().all();      		
	}
	
	@Test(priority = 2)
	public void digestaauth() {
		
      given()
          .auth().digest("postman", "password")
      
      .when()
           .get("https://postman-echo.com/basic-auth")
      .then()
		   .statusCode(200)
           .body("authenticated", equalTo(true)).log().all();      		
	}
	@Test(priority = 3)
	public void preementiveauth() {
		
      given()
          .auth().preemptive().basic("postman", "password")
      
      .when()
           .get("https://postman-echo.com/basic-auth")
      .then()
		   .statusCode(200)
           .body("authenticated", equalTo(true)).log().all();      		
	}
	@Test(priority = 4)
	public void ptiveauth() {
		String bearertoken="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";
      given()
          .headers("Authorization","bearer"+bearertoken)
      .when()
           .get("https://github.com/")
      .then()
		   .statusCode(200)
           .log().all();      		
	}
	@Test(priority = 4)
	public void OAuthentication() {
		
      given()
          .auth().oauth("consunerKey","consumerSecrat", "acessToken","tokenCreate" )
      .when()
           .get("url")
      .then()
		   .statusCode(200)
           .log().all();      		
	}
	@Test(priority = 4)
	public void OAuthentication2() {
		
      given()
          .auth().oauth2("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")
      .when()
           .get("https://github.com/")
      .then()
		   .statusCode(200)
           .log().all();      		
	}
	@Test(priority = 4)
	public void APIKeyAuthentication2() {
		String id="debb7c0d9db8d656fd4c50b173bb2677";
      given()
      .contentType(ContentType.JSON)
      
           .queryParam("apikey", "48b1b0b3dfd9704d83f122b8b7fce3d1")
      .when()
           .get("https://api.openweathermap.org")
      .then()
		   .statusCode(200)
           .log().body();      		
	}
	
	//api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7
	

}
