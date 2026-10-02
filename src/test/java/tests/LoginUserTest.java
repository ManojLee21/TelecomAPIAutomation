package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginUserTest extends BaseTest {

	@Test(groups = "loginUser", dependsOnGroups = "updateUser")
	public void loginUserTest() {

		String requestBody = "{" + "\"email\":\"" + BaseTest.userEmail + "\"," + "\"password\":\"myNewPassword\"" + "}";

		BaseTest.token = given().header("Content-Type", "application/json").body(requestBody).when()
				.post("/users/login").then().statusCode(200).body("token", org.hamcrest.Matchers.notNullValue())
				.extract().path("token");

		System.out.println("Login successful. New token received.");
	}
}