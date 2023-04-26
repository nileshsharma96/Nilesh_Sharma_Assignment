package Assignment.Assess;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "//reports//Report.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Assignment");

		reporter.config().setDocumentTitle("Assignment");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Automation QA Engineer", "Nilesh Sharma");

		/* extent.createTest(path); */

		return extent;
	}

}
