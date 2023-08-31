package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.http.HttpResponse.BodyHandler;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class differentwaysofPOST {
@Test
public void hashmap() {
	
	HashMap data=new HashMap();
	data.put("name", "venky");
	data.put("age",24);
	data.put("location", "kanigiri");
	String coursearr[]= {"c","c++"};
	data.put("course", coursearr);
	given()
	    .contentType(ContentType.JSON)
	    .body(data)
	.when()
	      .post(" http://localhost:3000/users")
	 .then()
	      .statusCode(201).log().all()
	      .body("name", equalTo("venky"))
	      .body("age", equalTo(24))
	      .body("location", equalTo("kanigiri"))
	      .body("course[0]",equalTo("c"))
	      .body("course", hasItems("c","c++"));

}
@Test
public void json() {
	
	JSONObject data=new JSONObject();
	data.put("name", "venky");
	data.put("age",24);
	data.put("location", "kanigiri");
	String coursearr[]= {"c","c++"};
	data.put("course", coursearr);
	given()
	    .contentType(ContentType.JSON)
	    .body(data.toString())
	.when()
	      .post(" http://localhost:3000/users")
	 .then()
	      .statusCode(201).log().all()
	      .body("name", equalTo("venky"))
	      .body("age", equalTo(24))
	      .body("location", equalTo("kanigiri"))
	      .body("course[0]",equalTo("c"))
	      .body("course", hasItems("c","c++"))
	      .header("content-Type", equalTo("application/json; charset=utf-8"));
           
}
@Test
public void pojo() {
	
	pojoclass data=new pojoclass();
	 
	data.setLocation("kanigiri");
	data.setName("venky");
	data.setAge(24);
	String coursearr[]= {"c","c++"};
	data.setCourse(coursearr);
	given()
    .contentType(ContentType.JSON)
    .body(data)
.when()
      .post(" http://localhost:3000/users")
 .then()
      .statusCode(201).log().all()
      .body("name", equalTo("venky"))
      .body("age", equalTo(24))
      .body("location", equalTo("kanigiri"))
      .body("course[0]",equalTo("c"))
      .body("course", hasItems("c","c++"));

}@Test
public void extenalfiles() throws FileNotFoundException {
	
	File file=new File("./body2.json");
	FileReader fl=new FileReader(file);
	JSONTokener js=new JSONTokener(fl);
	JSONObject data=new JSONObject(js);
	given()
	    .contentType(ContentType.JSON)
	    .body(data.toString())
	.when()
	      .post(" http://localhost:3000/users")
	 .then()
	      .statusCode(201).log().all()
	      .body("name", equalTo("venky"))
	      .body("age", equalTo(24))
	      .body("location", equalTo("kanigiri"))
	      .body("course[0]",equalTo("c"))
	      .body("course", hasItems("c","c++"))
	      .header("content-Type", equalTo("application/json; charset=utf-8"));
           
}
	
	

}
