package RestAssuredPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class fakerdata {
	@Test
	public void fakedata() {
		Faker faker=new Faker();
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String email=faker.internet().emailAddress();
		String phone=faker.phoneNumber().cellPhone();
		
		System.out.println("full name   "+fullname);
		System.out.println("first name   "+firstname);
		System.out.println("email  "+email);
		System.out.println("phone   "+phone);
	}

}
