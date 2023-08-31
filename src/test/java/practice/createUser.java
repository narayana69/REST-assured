package practice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class createUser {
	long id;
	//be5adbb24c7150b2b69651dcdab6f296d3c0432697b3312387a15d5aa9ba0e20
@Test
public void create_user() {
	
	Faker fake = new Faker(); 
	JSONObject jsonobj = new JSONObject();
	jsonobj.put("name", fake.name().fullName());
	jsonobj.put("gender", "male");
	jsonobj.put("email", fake.internet().emailAddress());
	jsonobj.put("status", "active");

	String bearer_Token = "be5adbb24c7150b2b69651dcdab6f296d3c0432697b3312387a15d5aa9ba0e20";

	long id = given()
	        .headers("Authorization","Bearer "+bearer_Token)
	        .contentType("application/json")
	        .body(jsonobj.toString())
	        .when()
	        .post("https://gorest.co.in/public/v2/users")
	        .jsonPath()
	        .getLong("id");
	System.out.println(id);
	
	
	
}
	
	
}
