package testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String testCaseName, testCaseDescription, 
					author, category,Filename;
	
	@BeforeSuite // One time execution 
	public void startResult() {
		ExtentHtmlReporter html = new ExtentHtmlReporter
				("./reports/result.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	@BeforeMethod 
	public void startTestCase() {
		test = extent
				.createTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	public void reportStep(String desc,String status) {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(desc);
		}if (status.equalsIgnoreCase("fail")) {
			test.fail(desc);
		}
	}
	
	@AfterSuite
	public void stopResult(){		
		extent.flush();
	}
}







