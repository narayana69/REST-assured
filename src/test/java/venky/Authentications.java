package venky;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {
@Test

public void basicauthentication() {
	given()
	
	 .auth()
	   .basic("postman","password")
	   
	 .when()
	     .get("http://postman-echo.com/basic-auth")
	     
	  .then().statusCode(200)
	  .body("authenticated", equalTo(true))
	  .log().all();   

}@Test

public void digestauthentication() {
	given()
	
	 .auth()
	   .digest("postman","password")
	   
	 .when()
	     .get("http://postman-echo.com/digest-auth")
	     
	  .then().statusCode(200)
	  .body("authenticated", equalTo(true))
	  .log().all();   

}@Test

public void preemitiveauthentication() {
	given()
	
	 .auth().preemptive()
	   .basic("postman","password")
	   
	 .when()
	     .get("http://postman-echo.com/basic-auth")
	     
	  .then().statusCode(200)
	  .body("authenticated", equalTo(true))
	  .log().all();   

}@Test

public void bearerauthentication() {
	
	String bearertoken="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";
	given()
	     .header("Authorization","Bearer "+bearertoken)
	 
	   
	 .when()
	     .get("https://api.github.com/user/repos")
	     
	  .then().statusCode(200)
	 
	  .log().all();   

}@Test

public void Oauth1() {
	
	given()
	    .auth().oauth("cosumerKey", "consumerSecrate", "accessToken","tokenSecrate")
	    
	.when()
	     .get("url")
	     
	 .then()
	 .statusCode(2000).log().all();
	
	
}@Test

public void Oauth2() {
	
	given()
	    .auth().oauth2("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")
	    
	.when()
	     .get("https://api.github.com/user/repos")
	     
	 .then()
	 .statusCode(200).log().all();
	
	
}@Test

public void APIkeyauthentication() {
//	
//	given()
//	    .queryParam("rowdy","5f54818619d1308d478a309e6aceb93c")
//	    
//	.when()
//	     .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=London&units=metric&cnt=7")
//	     
//	 .then()
//	 .statusCode(200).log().all();
//	
	given()
    .queryParam("rowdy","5f54818619d1308d478a309e6aceb93c")
    .pathParam("mypath","data/2.5/forecast/daily")
    .queryParam("q","London")
    .queryParam("units", "metric")
    .queryParam("cnt", "7")
    .when()
    .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=London&units=metric&cnt=7")
    
.then()
.statusCode(200).log().all();
}
}
