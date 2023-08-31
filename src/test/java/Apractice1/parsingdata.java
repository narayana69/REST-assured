package Apractice1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class parsingdata {
	
	@Test
	public void parsingdata() {
		//Aproach1
		given()
		
		
		.when()
		    .get("http://localhost:3000/users")
		
		.then()
		      .statusCode(200)
		      .body("students.name", hasItems("kotaiah","narayana","kulluri"))
		      .body("students.id",hasItems(1,2,3))
		      .log().all();
	}
	@Test
	public void parsingdata2() {
		//Aproach2
	Response res=	given()
		
		
		.when()
		    .get("http://localhost:3000/users");
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.header("content-type"), "application/json; charset=utf-8");
	String name=res.jsonPath().getString("students[1].name");
	Assert.assertEquals(name, "narayana");

	}boolean status=false;
	@Test
	public void parsingdata3() {
		//Aproach2
	Response res=	given()
		
		
		.when()
		    .get("http://localhost:3000/users");
	    JSONObject jo=new JSONObject(res.asString());
	    
	    for(int i=0;i<jo.getJSONArray("students").length();i++) {
	    	String k=jo.getJSONArray("students").getJSONObject(i).getString("name").toString();
	    	System.out.println(k);
	    	if(k.equalsIgnoreCase("kulluri")) {
	    		status=true;
	    		break;
	    	}
	    	}Assert.assertEquals(status, true);
	    }@Test
	    public void parsingdata4() {
	    	
			//Aproach2
		Response res=	given()
			
			
			.when()
			    .get("http://localhost:3000/users");
		    JSONObject jo=new JSONObject(res.asString());
		    double idsum=0;
		    
		    for(int i=0;i<jo.getJSONArray("students").length();i++) {
		    	String k=jo.getJSONArray("students").getJSONObject(i).get("id").toString();
		    	idsum=idsum+Double.parseDouble(k);
		    }System.out.println(idsum);
		    Assert.assertEquals(idsum, 6);

	}
	

}
