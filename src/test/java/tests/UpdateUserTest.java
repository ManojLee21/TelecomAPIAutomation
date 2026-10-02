package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserTest extends BaseTest {

	@Test(groups = "updateUser", dependsOnGroups = "getUserProfile")
	public void updateUserTest() {

		String requestBody = "{" + "\"firstName\":\"Updated\"," + "\"lastName\":\"Username\"," + "\"email\":\""
				+ BaseTest.userEmail + "\"," + "\"password\":\"myNewPassword\"" + "}";

		given().header("Authorization", "Bearer " + BaseTest.token).header("Content-Type", "application/json")
				.body(requestBody).when().patch("/users/me").then().statusCode(200)
				.body("firstName", org.hamcrest.Matchers.equalTo("Updated"))
				.body("lastName", org.hamcrest.Matchers.equalTo("Username"))
				.body("email", org.hamcrest.Matchers.equalTo(BaseTest.userEmail));
	}
}