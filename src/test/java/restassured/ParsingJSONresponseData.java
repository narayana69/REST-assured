package restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import  org.json.JSONObject;
import java.util.Iterator;

import org.json.JSONArray;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ParsingJSONresponseData {
	private boolean Status;
	@Test
	
	public void testJsonresponse() {
		
     //APROACH 1
		
		
	    given()
		    .contentType(ContentType.JSON) 
		
	    .when()
	         .get("http://localhost:3000/users")
	    
	    .then()
	         .statusCode(200)
	         .header("Content-Type", "application/json; charset=utf-8")
	         .body("names[1][\"phone no\"]", equalTo("7036637064"))
	         .log().all();
		
		
		
		//APROACH 2
	Response res=	 given()
		    .contentType(ContentType.JSON) 
		
	    .when()
	         .get("http://localhost:3000/users");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		
		String namess=res.jsonPath().get("names[1].location").toString();
		Assert.assertEquals(namess, "bengluru");
		
	}
@Test
	
	public void testJsonresponseBodyData() {
		
	Response res=	 	given().header("Content-Type","application/json;charset=utf-8").contentType(ContentType.JSON).accept(ContentType.JSON)
	    .when()
	         .get("  http://localhost:3000/users");
	JSONObject jo=new JSONObject(res.asString());
		for(int a=0;a<jo.getJSONArray("names").length();a++) {
		String k=jo.getJSONArray("names").getJSONObject(a).get("name").toString();
		
			System.out.println(k);
			
		}
	
	}

}
