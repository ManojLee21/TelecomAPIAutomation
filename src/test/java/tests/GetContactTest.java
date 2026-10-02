package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetContactTest extends BaseTest {

	@Test(groups = "getContact", dependsOnGroups = "getContactList")
	public void getContactTest() {

		given().header("Authorization", "Bearer " + BaseTest.token).when().get("/contacts/" + BaseTest.contactId).then()
				.statusCode(200).body("_id", org.hamcrest.Matchers.equalTo(BaseTest.contactId))
				.body("firstName", org.hamcrest.Matchers.equalTo("John"))
				.body("lastName", org.hamcrest.Matchers.equalTo("Doe"));
	}
}