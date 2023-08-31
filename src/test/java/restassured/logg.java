package restassured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class logg {
	@Test(priority = 1)
	public void log_method() {
			
		given()
		      
		
	    .when()
	         .get("https://www.google.com/")
	    
	    .then()
	      //   .cookie("AEC","Ad49MVEk4_bJUreis8F0SM817X6oEUh8vI0KD59qEQFbYMPUR3iPg9s3C2c")
	         .statusCode(200)
	         //it gives all cookies headers body
		
//	       .log().all();
	         
	         // gives only headers
	    //     .log().headers(); 
	         //gives only cookis
	       //  .log().cookies();
		//gives bidy
		.log().body();
	}

}
