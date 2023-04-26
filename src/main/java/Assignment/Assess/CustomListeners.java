package Assignment.Assess;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class CustomListeners extends Base implements ITestListener {

	ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		test.log(Status.INFO, "Test Started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getDescription().toString());
		test.log(Status.PASS, "Test Case Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getDescription().toString());
		test.log(Status.FAIL, "Test Case Failed");
		extentTest.get().fail(result.getThrowable());

		try {
			extentTest.get().info(MediaEntityBuilder
					.createScreenCaptureFromBase64String(getScreenshot(result.getMethod().getMethodName(), driver))
					.build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
