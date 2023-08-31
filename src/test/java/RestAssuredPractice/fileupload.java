package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class fileupload {
	@Test
	public void file_upload() {
		File myfile=new File("./text1");
		given()
		    .multiPart("file",myfile)
		    .contentType(ContentType.MULTIPART)
		.when()
		     .post("http://localhost:8080/uploadFile")
		     
		 .then()
		      .statusCode(200).log().all();
	}
	
		@Test
		public void mulfile_upload() {
			File myfile=new File("./text1");
			File myfile1=new File("./text2");

			
			given()
			    .multiPart("files",myfile)
			    .multiPart("files",myfile1)
                .contentType(ContentType.MULTIPART)
			.when()
			     .post("http://localhost:8080/uploadMultipleFiles")
			     
			 .then()
			      .statusCode(200).log().all();
		}@Test
		public void download() {
			

			
			given()
			   

			.when()
			     .get("http://localhost:8080/downloadFile/text2")
			     
			 .then()
			      .statusCode(200).log().all();
		}
		

}
