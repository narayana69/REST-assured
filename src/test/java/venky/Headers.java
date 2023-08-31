package venky;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Headers {
	@Test
	public void headers() {
		
   	given()
	             .contentType(ContentType.JSON)	
	        .when() 
	             .get("https://www.google.com/")
	        .then().
	        header("Content-Type", "text/html; charset=ISO-8859-1")
	        .header("Content-Encoding", "gzip")
	        .header("Server","gws")
	        .statusCode(200).log().headers();     
		
	}
	@Test
	public void getheaders() {
		
     Response res= 	given()
	             .contentType(ContentType.JSON)	
	        .when() 
	             .get("https://www.google.com/");
     
//     //get single header
//  String k=   res.getHeader("content-type");
//  System.out.println(k);
  // get all cookies
  
  io.restassured.http.Headers heds= res.getHeaders();
  for(Header k1:heds) {
	  
	
	 System.out.println(k1.getName()+"    "+k1.getValue());
	  
  }

	}
}
