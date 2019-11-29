package com.demo.TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.demo.pages.Homepage;
import com.demo.utility.ConfigReader;
import com.demo.utility.ListnerHelp;
import com.demo.utility.ScreenshotHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListnerHelp.class)
public class BaseClass {

	public static WebDriver driver;
	ConfigReader cr;
	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		Homepage h;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		cr=new ConfigReader();
		driver.manage().window().maximize();
		driver.get(cr.geturl());
		System.out.println("URL Launched");
		h=new Homepage(driver); 
		Thread.sleep(2000);
		h.popupclose();
	}

	@BeforeTest
	public void setExtent() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+dateName+"ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Aditya PC");
		extent.addSystemInfo("User Name", "Aditya Prasad");
		extent.addSystemInfo("Environment", "Testing");
	}
	
	@AfterTest
	public void endExtent() {
		extent.flush();
		extent.close();
	}
	
	@AfterMethod
	public void reporting(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ScreenshotHelper.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			String screenshotPath = ScreenshotHelper.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
		}
		extent.endTest(extentTest);
		
	}
	
	@AfterSuite public void Closebrowser() { 
		driver.close();
		System.out.println("Session closed");
		driver.quit();
		System.out.println("Browser closed"); 
	}

}
