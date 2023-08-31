package venky;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class fakerDataGenarater {

	@Test
	public void testgeranatedummydata() {
		
		Faker faker=new Faker();
		
		
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String lastnmae=faker.name().lastName();
		String username=faker.name().username();
		String email=faker.internet().safeEmailAddress();
		String password=faker.internet().password();
		String phonenumber=faker.phoneNumber().cellPhone();
		
		
		System.out.println("FullName:"+fullname);
		System.out.println("lastName:"+lastnmae);
		System.out.println("firstName:"+firstname);
		System.out.println("userName:"+username);
		System.out.println("email:"+email);
		System.out.println("password:"+password);
		System.out.println("phonenumber:"+phonenumber);
	}
	
}
