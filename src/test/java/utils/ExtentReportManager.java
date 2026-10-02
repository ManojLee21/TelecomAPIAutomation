package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getReportInstance() {

		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("Project", "Telecom API Automation");
			extent.setSystemInfo("Tester", "Leelaa Vinothinie");
			extent.setSystemInfo("Framework", "RestAssured + TestNG");
			extent.setSystemInfo("Environment", "API Testing");
		}

		return extent;
	}
}