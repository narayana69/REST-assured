package venky;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class fileupload {
	@Test
	
	public void singlefileupload() {
		
		File myfile=new File(".\\text1");
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
public void multiplefilesupload() {
		
		File myfile1=new File(".\\text1");
		File myfile2=new File(".\\text2");
		//File filarr[]= {myfile1,myfile2};
		given()
		   .multiPart("files",myfile1)
		   .multiPart("files",myfile2)
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
		
		given()
		   
		.when()
		   .get("http://localhost:8080/downloadFile/text2")

	    .then()
	      .statusCode(200).log().body();
	
	}
	
	

}
