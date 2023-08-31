package restassured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DifferentWaysCreatePostRequestBody {
	
	
	//@Test(priority = 1)
	public void testpost_using_Hasmap() {
		
	HashMap data=new HashMap();
	
	data.put("name", "sunaina");
	data.put("location", "guntur");
	data.put("phone", "7730921106");
	String courseAR[]= {"saap","devops"};
	data.put("course", courseAR);
	
		given()
		    .contentType(ContentType.JSON)
		    .body(data)
	   .when()
		    .post("http://localhost:3000/users")
	   .then()
	         .statusCode(201)
	         .body("name", equalTo("sunaina"))
	         .body("location", equalTo("guntur"))
	         .body("phone", equalTo("7730921106"))
	         .body("course[0]", equalTo("saap"))
	         .body("course[1]", equalTo("devops"))
	         .header("Content-Type", "application/json; charset=utf-8")
	         .log().all();
	}

@Test(priority = 1)


public void testpost_using_pojo() {
	
	pojoclass data=new pojoclass();
	data.setName("venky");
	data.setPhone("765444343");
	data.setLocation("bengulur");
	String coursear[] ={"sapp","devops"};
	data.setCourse(coursear);

	given()
	    .contentType(ContentType.JSON)
	    .body(data)
   .when()
	    .post(" http://localhost:3000/users")
   .then()
         .statusCode(201)
         .body("name", equalTo("venky"))
         .body("location", equalTo("bengulur"))
         .body("phone", equalTo("765444343"))
         .body("course[0]", equalTo("sapp"))
         .body("course[1]", equalTo("devops"))
         .header("Content-Type", "application/json; charset=utf-8")
         .log().all();
}


//@Test(priority = 1)
public void testpost_using_externalfiles() throws FileNotFoundException {
	
File r=new File("./body.json");
FileReader da=new FileReader(r);
JSONObject data=new JSONObject();

data.put("name", "sunaina");
data.put("location", "guntur");
data.put("phone", "7730921106");
String courseAR[]= {"saap","devops"};
data.put("course", courseAR);

	given()
	    .contentType(ContentType.JSON)
	    .body(data)
   .when()
	    .post("http://localhost:3000/users")
   .then()
         .statusCode(201)
         .body("name", equalTo("sunaina"))
         .body("location", equalTo("guntur"))
         .body("phone", equalTo("7730921106"))
         .body("course[0]", equalTo("saap"))
         .body("course[1]", equalTo("devops"))
         .header("Content-Type", "application/json; charset=utf-8")
         .log().all();
}
@Test(priority = 1)
public void testpost_using_json()  {
	
JSONObject data=new JSONObject();

data.put("name", "sunaina");
data.put("location", "guntur");
data.put("phone", "7730921106");
String courseAR[]= {"saap","devops"};
data.put("course", courseAR);

	given()
	    .contentType(ContentType.JSON)
	    .body(data)
   .when()
	    .post("http://localhost:3000/users")
   .then()
         .statusCode(201)
         .body("name", equalTo("sunaina"))
         .body("location", equalTo("guntur"))
         .body("phone", equalTo("7730921106"))
         .body("course[0]", equalTo("saap"))
         .body("course[1]", equalTo("devops"))
         .header("Content-Type", "application/json; charset=utf-8")
         .log().all();
}
	@Test(priority = 2)
	public void delete() {
		given()
		
		
		.when()
		.delete("http://localhost:3000/users/5")
		.then()
		.statusCode(200);
//	}
	

	}
}
