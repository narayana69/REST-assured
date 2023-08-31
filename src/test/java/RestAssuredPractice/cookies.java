package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class cookies {
	@Test
	public void cookie() {
		
	Response res=	given()
		
		
		.when()
		     .get("https://www.google.com/");
		     
//		.then()
//		     .cookie("AEC","=Ad49MVG7EOo32FPReAjS1qMzCVmJaGGhYF1RIl5rKmE6AICT")
//		
//		    .statusCode(200)
//		    .log().cookies();
		  //get single cookie   
	String cooie=	res.getCookie("AEC").toString();     
	System.out.println(cooie);
	
	// all cookies
	
Map<String, String> cookies=	res.getCookies();
boolean status=false;
for(String c:cookies.keySet()) {
//	
//	String k=res.getCookie(c).toString();
//	System.out.println(c+"   "+k);
//	
	if(c.equalsIgnoreCase("Aec")) {
		status=true;
		break;
	}
}
Assert.assertEquals(status, true);
		
	}

}
