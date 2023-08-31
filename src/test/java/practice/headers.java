package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class headers {
	@Test
	public void cookie() {

		given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://www.google.com/")
		.then()
		 .header("server", "gws")
		.statusCode(200).log().headers();
	}

	@Test
	public void getcookie() {

		Response res=	given()
				.contentType(ContentType.JSON)
				.when()
				.get("https://www.google.com/");

//	String	k= res.getHeader("server").toString();
//		System.out.println(k);
		
	 Headers l=   res.getHeaders();
	System.out.println(l);
	for(Header k:l) {
		System.out.println(k.getName()+"  "+k.getValue());
	}
	
	
	}	
}
