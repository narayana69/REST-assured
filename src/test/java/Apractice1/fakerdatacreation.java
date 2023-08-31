package Apractice1;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
public class fakerdatacreation {
	@Test
	public void fakedatacreate() {
		Faker faker=new Faker();
		String username=faker.name().username();
		String fullname=faker.name().fullName();
		String email=faker.internet().emailAddress();
		String phone=faker.phoneNumber().cellPhone();
		System.out.println(username+":username");
		System.out.println(fullname+"fullname");
		System.out.println(email+"email");
		System.out.println(phone+"phone");
		

	}

}
