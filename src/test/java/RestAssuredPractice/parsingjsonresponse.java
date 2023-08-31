package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class parsingjsonresponse {
@Test
  public void testjsonresponse() {
	//approach 1
	given()
	     
	
	.when()
	      .get("  http://localhost:3000/users")
	
	.then()
	     .statusCode(200)
	     .body("students[1].name", equalTo("narayana"))
	     .header("content-type","application/json; charset=utf-8")
	     .body("students[2].id", equalTo(3));
	   
}@Test
  public void testjsonresponse2() {
	//approach 2
Response res=	given()
	     
	
	.when()
	      .get("  http://localhost:3000/users");
Assert.assertEquals(res.getHeader("content-type"), "application/json; charset=utf-8");
Assert.assertEquals(res.getStatusCode(),200);
String name=res.jsonPath().get("students[1].name");
Assert.assertEquals(name, "narayana");
   
}@Test
  public void testjsonresponse3() {
	//approach =	
Response res=	given()
	     .contentType(ContentType.JSON)
	     
	
	.when()
	      .get("  http://localhost:3000/users");

boolean status=false;
JSONObject jo=new JSONObject(res.asString());
for(int a=0;a<jo.getJSONArray("students").length();a++) {
	
	
	String data=jo.getJSONArray("students").getJSONObject(a).getString("name").toString();
	
	System.out.println(data);
	if(data.equalsIgnoreCase("venky")) {
		status =true;
	}
}Assert.assertEquals(status, true);

   
}
@Test
public void testjsonresponse4() {
	//approach =	
Response res=	given()
	     .contentType(ContentType.JSON)
	     
	
	.when()
	      .get("  http://localhost:3000/users");

double id_sum=0;
JSONObject jo=new JSONObject(res.asString());

for(int a=0;a<jo.getJSONArray("students").length();a++) 
{
	
	
	String ids=	jo.getJSONArray("students").getJSONObject(a).get("id").toString();
	
			id_sum=id_sum+Double.parseDouble(ids);
		
			
			
		}
System.out.println(id_sum);
		
	
Assert.assertEquals(id_sum, 15.0);

}	

  
}

