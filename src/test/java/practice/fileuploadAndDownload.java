package practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class fileuploadAndDownload {
	@Test
	
	public void fileupload() {
	
		File myfile1=new File("./file/venky.txt");
		File myfile2=new File("./file/venky2.txt");
	//	File filearr[]= {myfile1,myfile2};
		given()
		      .multiPart("files",myfile2)
             .multiPart("files",myfile1)
             .contentType("multipart/form-data")
		
		.when()
		     .post("http://localhost:8080/uploadMultipleFiles")
		.then()
		     .statusCode(200)
		     .body("[0].fileName", equalTo("venky2.txt"))
		     .body("[1].fileName", equalTo("venky.txt"))
		     .log().all();
		
	}
	@Test
	public void multiplefilesupload() {          //its would not working in all api's
		File myfile1=new File("./file/venky.txt");
		File myfile2=new File("./file/venky2.txt");
	File filearr[]= {myfile1,myfile2};
		given()
		      .multiPart("files",filearr)
          
             .contentType("multipart/form-data")
		
		.when()
		     .post("http://localhost:8080/uploadMultipleFiles")
		.then()
		     .statusCode(200)
		     .body("[0].fileName", equalTo("venky2.txt"))
		     .body("[1].fileName", equalTo("venky.txt"))
		     .log().all();
	
	}@Test
	public void downloadfile() {
		
		given()
		     
		.when()
		    .get("http://localhost:8080/downloadFile/venky.txt")
		.then().statusCode(200).log().body();    
		
		
		
	}

}
