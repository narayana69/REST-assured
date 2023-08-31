package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class cookies {
	@Test
	public void cookie() {

		given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://www.google.com/")
		.then()
		// .cookie("AEC","hsjhfjfsjfjsdjqgdjyt")
		.statusCode(200).log().all();
	}

	@Test
	public void getcookie() {

		Response res=	given()
				.contentType(ContentType.JSON)
				.when()
				.get("https://www.google.com/");

		//String k=	res.getCookie("AEC").toString();
		//System.out.println(k);
		
	Map<String, String> l=	res.getCookies();
	System.out.println(l.keySet());
	for(String k:l.keySet()) {
		String j=res.getCookie(k);
		System.out.println(k+"      "+j);
	}
	}	
}
