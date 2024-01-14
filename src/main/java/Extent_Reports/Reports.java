package Extent_Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports report() {

		ExtentReports report = new ExtentReports();
		String file = System.getProperty("user.dir") + "\\reports\\ereport.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);
		report.attachReporter(extentSparkReporter);
		return report;
	}
}
