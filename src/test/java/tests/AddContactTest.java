package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddContactTest extends BaseTest {

	@Test(groups = "addContact", dependsOnGroups = "loginUser")
	public void addContactTest() {

		String requestBody = "{" + "\"firstName\":\"John\"," + "\"lastName\":\"Doe\"," + "\"birthdate\":\"1970-01-01\","
				+ "\"email\":\"jdoe@fake.com\"," + "\"phone\":\"8005555555\"," + "\"street1\":\"1 Main St.\","
				+ "\"street2\":\"Apartment A\"," + "\"city\":\"Anytown\"," + "\"stateProvince\":\"KS\","
				+ "\"postalCode\":\"12345\"," + "\"country\":\"USA\"" + "}";

		BaseTest.contactId = given().header("Authorization", "Bearer " + BaseTest.token)
				.header("Content-Type", "application/json").body(requestBody).when().post("/contacts").then()
				.statusCode(201).body("_id", org.hamcrest.Matchers.notNullValue())
				.body("firstName", org.hamcrest.Matchers.equalTo("John"))
				.body("lastName", org.hamcrest.Matchers.equalTo("Doe")).extract().path("_id");

		System.out.println("Contact ID received: " + BaseTest.contactId);
	}
}