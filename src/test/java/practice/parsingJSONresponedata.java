package practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
public class parsingJSONresponedata {
	@Test
	public void testJosnpath() {
	//APPROACH 1
		given().contentType(ContentType.JSON)
		.when()
		     .get("http://localhost:3000/users")
		     .then().statusCode(200)
		     .body("names.name", hasItems("venky","narayana","kulluri"))
		     .and().body("names[1].course[1]", equalTo("python")).log().all();
		
		
		
	
	}
	//APPROACH 2
	@Test
	public void testJosnpath2() {
	
		
	Response res=	given().contentType(ContentType.JSON)
	.when()
	     .get("http://localhost:3000/users");
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	String k=res.jsonPath().getString("names[1].course[0]").toString();
	Assert.assertEquals(k, "java");
	}
	
	@Test
	public void testJosnpathBodydata() {
	//APPROACH 1
	Response res=	given().header("Content-Type","application/json; charset=utf-8")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when()
		     .get("http://localhost:3000/users");
		     
		JSONObject jo=new JSONObject(res.asString());
		boolean status=false;
		for(int a=1;a<jo.getJSONArray("names").length();a++) 
		{
			
			String k=jo.getJSONArray("names").getJSONObject(a).get("name").toString();
			if(k.equals("narayana")) {
			status = true;
			break;
			
			}
		}
		Assert.assertEquals(status, true);
	int toids=0;
		for(int a=0;a<jo.getJSONArray("names").length();a++) 
		{
			String k=jo.getJSONArray("names").getJSONObject(a).get("id").toString();
			toids=toids+Integer.parseInt(k);
			System.out.println(toids);
	}
		Assert.assertEquals(toids, 6);
	}
}
