package venky;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class parsingXmlresponse {
@Test
 public void testxmlresponseApproach1() {
	
	
	given()
	
	
	.when()
	    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
	.then()
	     .statusCode(200)
	     .header("Content-Type", "application/xml; charset=utf-8")
	     .body("TravelerinformationResponse.page",equalTo("1"))
	     .body("TravelerinformationResponse.travelers.Travelerinformation[2].name", equalTo("vano"));
}
@Test
public void testxmlresponseApproach2() {
	
	
Response res=	given()
	
	
	.when()
	    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
  String page=     res.xmlPath().get("TravelerinformationResponse.page").toString();
  Assert.assertEquals(page, "1");
  Assert.assertEquals(res.header("content-type"), "application/xml; charset=utf-8");
  Assert.assertEquals(res.getStatusCode(), 200);
  String name=     res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[2].name").toString();
  Assert.assertEquals(name, "vano");
}
@Test
public void testxmlresponsebody() {
	
	
Response res=	given()
	
	
	.when()
	    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
      XmlPath xo=new XmlPath(res.asString());
        List<String> names=xo.getList("TravelerinformationResponse.travelers.Travelerinformation");
// verify total no of travels
System.out.println(names.size());
Assert.assertEquals(names.size(), 10);
//verify the traveler name present in response body
boolean status=false;
List<String> travelsnames=xo.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
for(String k:travelsnames) {
	
	System.out.println(k);
	if(k.equals("Ashor")) {
		status=true;
		break;
	}
	
}Assert.assertEquals(status, true);
}

}
