package practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class parsinxmlresponse {
	
	//http://restapi.adequateshop.com/api/Traveler?page=1

	
		@Test
		
		public void testxmlresponse() {
			
	     //APROACH 1
			
			
		    given()
			    
		    .when()
		         .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		    
		    .then()
		         .statusCode(200)
		         
		         .body("TravelerinformationResponse.travelers.Travelerinformation.name[0]", equalTo("Developer"))
		         .body("TravelerinformationResponse.page", equalTo("1"))
		         .body("TravelerinformationResponse.travelers.Travelerinformation.id[0]", equalTo("11133"))
		         .log().all();
			
	}
		@Test
		public void testxmlresponse2() 	{
		
	     //APROACH 1
			
			 Response res=   given()
				                .contentType(ContentType.XML)
			    
		               .when()
		                     .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		    
		    Assert.assertEquals(res.getStatusCode(), 200);
		    Assert.assertEquals(res.header("Content-type"),"application/xml; charset=utf-8");
		    
		      String k=res.xmlPath().getString("TravelerinformationResponse.travelers.Travelerinformation.name[0]").toString();
		       
			Assert.assertEquals(k, "Developer");
	}
		
		@Test
		
		public void testJsonresponseBodyData() {
			
		Response res=	 	given().header("Content-Type","application/json;charset=utf-8").contentType(ContentType.JSON).accept(ContentType.JSON)
		    .when()
		         .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xo=new XmlPath(res.asString());
	List<String>	travelsinfo=    xo.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
			System.out.println(travelsinfo.size());	
			Assert.assertEquals(travelsinfo.size(), 10);
			
			List<String>	travelsinfos=    xo.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	boolean status=false;
			for(String travel:travelsinfos) {
		//  System.out.println(travel);
		  if(travel.equals("Developer123")) {
			  
			status=true;
			break;
		  }
	  }
			Assert.assertEquals(status, true);
			
			}

}
