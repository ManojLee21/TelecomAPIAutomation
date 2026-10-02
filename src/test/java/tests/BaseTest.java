package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import utils.ApiConfig;

@Listeners(utils.ExtentTestNGListener.class)

public class BaseTest {

	public static String token;
	public static String userEmail;
	public static String contactId;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = ApiConfig.BASE_URL;
	}
}