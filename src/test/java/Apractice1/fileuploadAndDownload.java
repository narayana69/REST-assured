package Apractice1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import com.github.javafaker.File;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
public class fileuploadAndDownload {
	@Test
	public void fileupload() {
		java.io.File myfile =new java.io.File(".\\text1");
		given()
		     .multiPart("file",myfile)
		     .contentType(ContentType.MULTIPART)
		
		
		.when()
		    .post("http://localhost:8080/uploadFile")
		
		.then()
		      .statusCode(200)
		      .body("fileName", equalTo("text1"))
		      .log().all();
	}@Test
	public void multiplefileupload() {
		java.io.File myfile =new java.io.File(".\\text1");
		java.io.File myfile1 =new java.io.File(".\\text2");
		
		given()
		     .multiPart("files",myfile)
		     .multiPart("files",myfile1)
		     .contentType(ContentType.MULTIPART)
		
		
		.when()
		    .post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
		      .statusCode(200)
		      .body("fileName[0]", equalTo("text1"))
		      .body("fileName[1]", equalTo("text2"))
		      .log().all();
	}
	@Test
	public void filedownload() {
	//	java.io.File myfile =new java.io.File(".\\text1");
		given()
		    // .multiPart("file",myfile)
		    // .contentType(ContentType.MULTIPART)
		
		
		.when()
		    .get("http://localhost:8080/downloadFile/text1")
		    
		.then()
		      .statusCode(200)
		      //.body("fileName", equalTo("text1"))
		      .log().all();

}}
