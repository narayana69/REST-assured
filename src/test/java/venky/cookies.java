package venky;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class cookies {
	
	@Test
	public void cookies() {
		
		
	Response res=	given()
             .contentType(ContentType.JSON)	
        .when() 
             .get("https://www.google.com/");
	// get single cookie
	
//String cooikeval=	res.getCookie("AEC");
//System.out.println("cookie value is"+cooikeval);
	
	
	//GET ALL COOIKES
	
 Map<String, String> cookies=  res.getCookies();
 System.out.println(cookies.keySet());
 
 for(String k:cookies.keySet()) {
	// String cookie=res.getCookie(k);
	 if(k.equalsIgnoreCase("Aec")) {
		 String cookie=res.getCookie(k); 
		 System.out.println(k+"  "+cookie);
	 }
	// System.out.println(k+"  "+cookie);
 }
             
          // EVERY TIME COOKIE VALUE IS CHANGE   
//         .then().
//         cookie("AEC","Ad49MVGEJvk6Hhd88WCd74EsYtY8h1dsCHW0IiYjPMdT77anwDFW-")
//         .
//         statusCode(200).log().cookies();    
//		
	}

}
