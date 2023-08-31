package Apractice1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class parsinxml {
	@Test
	public void parsingxml() {
		//Aproach 1
		given()
		
		
		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.header("Content-Type", "application/xml; charset=utf-8")
	     .body("TravelerinformationResponse.page",equalTo("1"))
	     .body("TravelerinformationResponse.travelers.Travelerinformation[2].name", equalTo("vano"));
	
	}
	@Test
	public void parsingxm2() {
		//Aproach 1
	Response res=	given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getHeader("content-type"), "application/xml; charset=utf-8");
		Assert.assertEquals(res.getStatusCode(),200);
		String v=res.xmlPath().getString("TravelerinformationResponse.page");
		Assert.assertEquals(v,"1");

	}@Test
	public void parsingxm3() {
	//Aproach 1
	Response res=	given()
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	//	boolean status=false;
		XmlPath xo=new XmlPath(res.asString());
		List<String> xmlo=xo.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		System.out.println(xmlo.size());
		int size=xmlo.size();
		for(String d:xmlo) {
			System.out.println(d);
			if(d.equalsIgnoreCase("1234")) {
				break;
			}
			
		}Assert.assertEquals(size, 10);

		
		
		
}}
