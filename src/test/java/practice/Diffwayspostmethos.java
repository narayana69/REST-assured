package practice;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.http.HttpResponse.BodyHandler;
import java.util.HashMap;
public class Diffwayspostmethos {
	@Test
	public void hasmethod() {
		HashMap data= new HashMap();
		data.put("name", "venky");
		data.put("house", "kulluri");
		given()
		.contentType(ContentType.JSON)
		.body(data)
       . when()
             .post("https://reqres.in/api/users")
             
	
        .then().statusCode(201) 
        .body("name", equalTo("venky"))
        .body("house", equalTo("kulluri"))
       .log().all();
	}@Test
	public void jsonmethod() {
		JSONObject data=new JSONObject();
		data.put("name", "venky");
		data.put("house", "kulluri");
		String cor[]= {"testing","restassured"};
		data.put("course", cor);
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
       . when()
             .post("https://reqres.in/api/users")
             
	
        .then().statusCode(201) 
        .body("name", equalTo("venky"))
        .body("house", equalTo("kulluri"))
        .body("course[1]", equalTo("restassured"))
       .log().all();
		
	}
	@Test
	public void pojomethod() {
		pojoclass pojo=new pojoclass();
		pojo.setName("venky");
		pojo.setLast_name("kulluri");
		String cr[]= {"dta","venky"};
		pojo.setCourse(cr);
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
       . when()
             .post("https://reqres.in/api/users")
             
	
        .then().statusCode(201) 
        .body("name", equalTo("venky"))
        .body("last_name", equalTo("kulluri"))
        .body("course[1]", equalTo("venky"))
       .log().all();
		
	}@Test
	public void filesmethod() throws FileNotFoundException {
		File file=new File("./body.json");
		FileReader f=new FileReader(file);
		
		JSONObject data=new JSONObject(f);
		data.put("name", "venky");
		data.put("house", "kulluri");
		String cor[]= {"testing","restassured"};
		data.put("course", cor);
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
       . when()
             .post("https://reqres.in/api/users")
             
	
        .then().statusCode(201) 
        .body("name", equalTo("venky"))
        .body("house", equalTo("kulluri"))
        .body("course[1]", equalTo("restassured"))
       .log().all();
		
	}
}
