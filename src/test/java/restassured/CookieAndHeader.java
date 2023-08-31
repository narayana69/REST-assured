package restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookieAndHeader {
	@Test(priority = 1)
	public void cookie_method() {
			
		given()
		      
		
	    .when()
	         .get("https://www.google.com/")
	    
	    .then()
	      //   .cookie("AEC","Ad49MVEk4_bJUreis8F0SM817X6oEUh8vI0KD59qEQFbYMPUR3iPg9s3C2c")
	         .statusCode(200)
	         
	         .log().all();
		
	}
	@Test
	public void get_cookies_method() {
	Response res=	given()
		      
		
	    .when()
	         .get("https://www.google.com/");
		//get single cookie value
//		String k= res.getCookie("AEC");
//				System.out.println(k);
	
	
	//get all cookies
	
	
	Map<String, String> k =res.getCookies();
	System.out.println(k.keySet());
	for(String e:k.keySet()) {
		String m=res.getCookie(e);
		System.out.println(e+"  "+m);
	}
				
				
				
		
//	    .then().statusCode(200).log().all();
	         ;
	    //get single cookie info
//	    String cookieres=res.getCookie("AEC");
//	    System.out.println("value of the "+cookieres);
		//get all cookie info
	
////	Map<String, String> cookieres=res.getCookies();
////	System.out.println(cookieres.keySet());
//	
//	for(String k:cookieres.keySet()) {
//		
//		 String cookieres1=res.getCookie(k);
//		System.out.println(k+"       "+cookieres1);
//	}
	}
}
