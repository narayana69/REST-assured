package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import javax.xml.crypto.dsig.XMLObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import io.restassured.path.xml.XmlPath;
public class parsingxmlresponse {
	@Test
	public void xmlresponse() {
		
	 given()
				.when()
				   .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		   .statusCode(200)
		   .body("TravelerinformationResponse.travelers.Travelerinformation[2].name", equalTo("vano"))
		   .body("TravelerinformationResponse.page", equalTo("1"))
		   .header("content-type","application/xml; charset=utf-8")
		   .log().all();
		
	}
	@Test
	public void xmlresponse2() {
		
	io.restassured.response.Response res= given()
				.when()
				   .get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	
//	Assert.assertEquals(res.getStatusCode(),200);
//	Assert.assertEquals(res.header("content-type"),"application/xml; charset=utf-8");
//	String resss=res.xmlPath().getString("TravelerinformationResponse.travelers.Travelerinformation[2].name");
//	Assert.assertEquals(resss,"vano");
	boolean status=false;
      XmlPath xo=new XmlPath(res.asString());
      List<String> ok=xo.getList("TravelerinformationResponse.travelers.Travelerinformation.name") ;
      for(String k:ok) {
    	  System.out.println(k);
    	  if(k.equalsIgnoreCase("vano")) {
    		  status=true;
    		  break;
    	  }
      }Assert.assertEquals(status, true);
      
	}
}
