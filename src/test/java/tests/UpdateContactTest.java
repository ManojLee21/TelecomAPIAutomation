package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateContactTest extends BaseTest {

	@Test(groups = "updateContact", dependsOnGroups = "getContact")
	public void updateContactTest() {

		String requestBody = "{" + "\"firstName\":\"Amy\"," + "\"lastName\":\"Miller\","
				+ "\"birthdate\":\"1992-02-02\"," + "\"email\":\"amiller@fake.com\"," + "\"phone\":\"8005554242\","
				+ "\"street1\":\"13 School St.\"," + "\"street2\":\"Apt. 5\"," + "\"city\":\"Washington\","
				+ "\"stateProvince\":\"QC\"," + "\"postalCode\":\"A1A1A1\"," + "\"country\":\"Canada\"" + "}";

		given().header("Authorization", "Bearer " + BaseTest.token).header("Content-Type", "application/json")
				.body(requestBody).when().put("/contacts/" + BaseTest.contactId).then().statusCode(200)
				.body("_id", org.hamcrest.Matchers.equalTo(BaseTest.contactId))
				.body("firstName", org.hamcrest.Matchers.equalTo("Amy"))
				.body("lastName", org.hamcrest.Matchers.equalTo("Miller"))
				.body("email", org.hamcrest.Matchers.equalTo("amiller@fake.com"));
	}
}