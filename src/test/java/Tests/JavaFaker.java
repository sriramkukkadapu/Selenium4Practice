package Tests;

import com.github.javafaker.Faker;

/* sources
 * 
 * https://github.com/DiUS/java-faker
 * 
 * https://medium.com/@iamfaisalkhatri/writing-selenium-web-automation-tests-in-fluent-way-864db95ee67a
 * 
 * mukesh otwani channel also has a video on this
 */

public class JavaFaker {
public static void main(String args[]) {
	Faker faker = new Faker();

	String name = faker.name().fullName(); // Miss Samanta Schmidt
	String firstName = faker.name().firstName(); // Emory
	String lastName = faker.name().lastName(); // Barton

	String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
//	String email = faker.
	
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(name);
	System.out.println(streetAddress);
	
	System.out.println(faker.address().city());
	System.out.println(faker.country().currency());
	System.out.println(faker.internet().emailAddress());
	System.out.println(faker.address().zipCode());
	System.out.println(faker.internet().uuid());
	System.out.println(faker.demographic().race());
	System.out.println(faker.demographic().sex());
	System.out.println(faker.demographic().maritalStatus());
	System.out.println(faker.number().numberBetween(9000000000L,9999999999L));
	
	System.out.println(faker.phoneNumber().cellPhone());
}
}
