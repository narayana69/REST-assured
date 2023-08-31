package practice;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class fakerdatacreate {
	@Test
	public void fakedate() {
		Faker faker = new Faker();

		String name = faker.name().fullName(); // Miss Samanta Schmidt
		String firstName = faker.name().firstName(); // Emory
		String lastName = faker.name().lastName();
		String email=	faker.internet().safeEmailAddress();
		String phonenum=faker.phoneNumber().cellPhone();
		String username=faker.name().username();
		String password=faker.internet().password();
		System.out.println("name  :"+name);
		System.out.println("firstname  :"+firstName);
		System.out.println("lastname  :"+lastName);
		System.out.println("email  :"+email);
		System.out.println("username   :"+username);
		System.out.println("password   :"+password);
		System.out.println("phone number    :"+phonenum);
	}

}
