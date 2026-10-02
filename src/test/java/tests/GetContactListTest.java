package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetContactListTest extends BaseTest {

	@Test(groups = "getContactList", dependsOnGroups = "addContact")
	public void getContactListTest() {

		given().header("Authorization", "Bearer " + BaseTest.token).when().get("/contacts").then().statusCode(200)
				.body("_id", org.hamcrest.Matchers.hasItem(BaseTest.contactId));
	}
}