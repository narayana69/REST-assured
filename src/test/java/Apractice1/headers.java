package Apractice1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.Assert;
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
			
//			.then()
//			      .statusCode(200)
//			     .header("content-type","text/html; charset=ISO-8859-1")
	//           .header("server","gws")
	         //  .header("Content-Encoding"gzip"}
//			      .log().headers();
			 boolean status=false;   
		String k=	 res.getHeader("content-type");
		System.out.println(k);
		Headers headers=res.getHeaders();
		System.out.println(headers);
		for(Header e:headers) {
			
			System.out.println(e.getName()+"   "+e.getValue());
			
			
		}//Assert.assertEquals(status, true);
	
}
}
