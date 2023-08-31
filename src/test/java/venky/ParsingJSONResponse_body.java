package venky;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParsingJSONResponse_body {
	
	@Test
	public void testjsonresponse1stapproach() {
		given()
		.contentType(ContentType.JSON)
		
		.when()
		
		  .get("http://localhost:3000/users")
		.then()
		.header("Content-Type","application/json; charset=utf-8")
		.body("students[1].name", equalTo("narayana"))
		.statusCode(200).log().all();
	}
	@Test
	public void testjsonresponse2approach() {
	Response res=	given()
		.contentType(ContentType.JSON)
		
		.when()
		
		  .get("http://localhost:3000/users");
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
	String name=	res.jsonPath().get("students[1].name").toString();
	Assert.assertEquals(name, "narayana");
	}
	
	@Test
	public void testjsonresponsebodydata() {
	Response res=	given()
		.contentType(ContentType.JSON)
		
		.when()
		
		  .get("http://localhost:3000/users");
	
	JSONObject oj=new JSONObject(res.asString());
//	for(int a=0;a<oj.getJSONArray("students").length();a++) {
//		
//		
//	String names=	oj.getJSONArray("students").getJSONObject(a).get("name").toString();
//		System.out.println(names);
//		
////	}
//	boolean status=false;
//	for(int a=0;a<oj.getJSONArray("students").length();a++) 
//	{
//		
//		
//		String names=	oj.getJSONArray("students").getJSONObject(a).get("name").toString();
//			if(names.equalsIgnoreCase("narayaNa")) {
//				status= true;
//				break;
//			}
//			
//		}
//	Assert.assertEquals(status, true);
	double id_sum=0;
	for(int a=0;a<oj.getJSONArray("students").length();a++) 
	{
		
		
		String ids=	oj.getJSONArray("students").getJSONObject(a).get("id").toString();
		
				id_sum=id_sum+Double.parseDouble(ids);
			
				
				
			}
	System.out.println(id_sum);
			
		
	Assert.assertEquals(id_sum, 19.0);
	
	}	
	
}
