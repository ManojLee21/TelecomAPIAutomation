package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserProfileTest extends BaseTest {

	@Test(groups = "getUserProfile", dependsOnGroups = "addUser")
	public void getUserProfileTest() {

		given().header("Authorization", "Bearer " + BaseTest.token).when().get("/users/me").then().statusCode(200)
				.body("email", org.hamcrest.Matchers.equalTo(BaseTest.userEmail));
	}
}