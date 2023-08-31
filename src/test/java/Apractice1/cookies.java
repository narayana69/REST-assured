package Apractice1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class cookies {
	@Test
	public void cookies() {
	Response res=	given()
		
		
		.when()
		    .get("https://www.google.com/");
		
//		.then()
//		      .statusCode(200)
//		      .cookie("NID","511")
//		      .log().cookies();
		 boolean status=false;   
	String k=	 res.getCookie("NID").toString();
	System.out.println(k);
	Map<String , String> cookies=res.getCookies();
	System.out.println(cookies.keySet());
	for(String e:cookies.keySet()) {
//		String l=res.getCookie(e);
//		System.out.println(e+"   "+l);
		if(e.equalsIgnoreCase("AEC")) {
			status=true;
			break;
		}
		
	}Assert.assertEquals(status, true);
	}

}
