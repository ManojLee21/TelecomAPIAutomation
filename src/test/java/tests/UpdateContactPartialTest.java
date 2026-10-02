package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateContactPartialTest extends BaseTest {

	@Test(groups = "updateContactPartial", dependsOnGroups = "updateContact")
	public void updateContactPartialTest() {

		String requestBody = "{" + "\"firstName\":\"Anna\"" + "}";

		given().header("Authorization", "Bearer " + BaseTest.token).header("Content-Type", "application/json")
				.body(requestBody).when().patch("/contacts/" + BaseTest.contactId).then().statusCode(200)
				.body("_id", org.hamcrest.Matchers.equalTo(BaseTest.contactId))
				.body("firstName", org.hamcrest.Matchers.equalTo("Anna"))
				.body("lastName", org.hamcrest.Matchers.equalTo("Miller"));
	}
}