package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddUserTest extends BaseTest {

	@Test(groups = "addUser")
	public void addNewUserTest() {

		BaseTest.userEmail = "leelaa.restassured." + System.currentTimeMillis() + "@example.com";

		String requestBody = "{" + "\"firstName\":\"Test\"," + "\"lastName\":\"User\"," + "\"email\":\""
				+ BaseTest.userEmail + "\"," + "\"password\":\"myPassword\"" + "}";

		BaseTest.token = given().header("Content-Type", "application/json").body(requestBody).when().post("/users")
				.then().statusCode(201).body("user.email", org.hamcrest.Matchers.equalTo(BaseTest.userEmail))
				.body("token", org.hamcrest.Matchers.notNullValue()).extract().path("token");

		System.out.println("User email: " + BaseTest.userEmail);
		System.out.println("Token received successfully");
	}
}