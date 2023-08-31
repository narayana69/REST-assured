package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class headers {
	@Test
	public void headers() {
	Response res=	given()
		
		.when()
		   .get("https://www.google.com/");
		
//		.then()
//		     .statusCode(200).log().headers()	
//		     .header("content-type","text/html; charset=ISO-8859-1")
//		     .header("Content-Encoding","gzip")
//		     .header("Server", "gws");
	
	//GET SINGLE HEAD
	
String head=	res.getHeader("content-type").toString();
System.out.println(head);

     //GET ALL HEADERS
          Headers hd=      res.getHeaders();
          for(Header h:hd) {
        System.out.println(h.getName()+"    "+h.getValue());
        	  
        	 
          }
	
	}

}
