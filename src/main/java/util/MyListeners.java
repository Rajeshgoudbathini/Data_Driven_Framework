package util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Extent_Reports.Reports;

public class MyListeners extends MyScreenshot implements ITestListener {
	ExtentReports extentreport = Reports.report();
	ExtentTest eTest;

	@Override
	public void onStart(ITestContext Context) {
		System.out.println("---Test Execution got Started---");

	}

	@Override
	public void onTestStart(ITestResult result) {
		// extentreport = Reports.report();
		eTest = extentreport.createTest(result.getName());

		eTest.log(Status.INFO, "---Test Execution got Started---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// String testname = result.getTestName();
		eTest.log(Status.PASS, "---Test Execution got Success---");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		eTest.log(Status.FAIL, "---Test Execution got Failed---");

		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		eTest.addScreenCaptureFromPath(takescreenshot(driver));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// String testname = result.getTestName();
		eTest.log(Status.SKIP, "---Test Execution got Skipped---");
	}

	@Override
	public void onFinish(ITestContext Context) {

		extentreport.flush();
		System.out.println("---Test Execution got finished---");

	}

}
