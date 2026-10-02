package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogoutUserTest extends BaseTest {

	@Test(groups = "logoutUser", dependsOnGroups = "updateContactPartial")
	public void logoutUserTest() {

		given().header("Authorization", "Bearer " + BaseTest.token).when().post("/users/logout").then().statusCode(200);
	}
}