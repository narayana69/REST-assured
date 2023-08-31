package restassured;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headders {                      //   Content-Type: text/html;Content-Security-Policy-Report-Only:
	@Test
	public void header_method() {            //Content-Encoding: gzip,	Server: gws
	
		
	given()
		      
		
	    .when()
	         .get("https://www.google.com/")
	
	    .then()
	    
	       .header("Server", "gws")
	       .header("Content-Encoding","gzip")
	       .statusCode(200);
	    
	    
		
	}
	@Test
	public void getheader_method() {            //Content-Encoding: gzip,	Server: gws
	
		
Response res=	given()
		      
		
	    .when()
	         .get("https://www.google.com/");
	//get single header
	   String k=res.getHeader("Server");
	   System.out.println(k);
	    
	  //get multiple header
	   
	 Headers m=res.getHeaders();
	   for(Header  h:m) {
		   System.out.println(h.getName()+"  "+h.getValue());
		   
	   }
	   
	   
		
	}
	
	

}
