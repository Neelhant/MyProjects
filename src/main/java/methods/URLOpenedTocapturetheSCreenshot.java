package methods;

import java.awt.AWTException;
import java.io.IOException;
import ExtentReports.ExtentReportDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Utility.CaptureScreenshotUsingRobot;


public class URLOpenedTocapturetheSCreenshot extends ExtentReportDemo{

	WebDriver driver;
	
	//ExtentReportDemo report= new ExtentReportDemo();

	@BeforeTest

	public void test() {
	}

	// TakesScreenshotUsingJavascriptexeFullPage tsc = new
	// TakesScreenshotUsingJavascriptexeFullPage();
	

	@Test
	public void urlopened() throws AWTException, IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/arihantjain/SelemiumTester/HybridFramework/src/main/java/Settings/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://stackoverflow.com/questions/25418958/unable-to-open-chrome-using-selenium");
		System.out.println("Title of the page " + driver.getTitle());


	//driver.findElement(By.className("jhj")).sendKeys("ghj");
		// This is working inside this methods . not workig with itestresult
		// TakesScreenshotUsingJavascriptexeFullPage tsc = new
		// TakesScreenshotUsingJavascriptexeFullPage();
		// tsc.javascriptexe(driver);
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws AWTException, IOException, InterruptedException {
		System.out.println("Screenshot taken");
		if (ITestResult.FAILURE == result.getStatus()) {
			// TakesScreenshotUsingJavascriptexeFullPage tsc = new
			// TakesScreenshotUsingJavascriptexeFullPage();
			// tsc.javascriptexe();
			// workings
			
			
		//String filepath=	TakesScreenshotUsingJavascriptexeFullPage.CaptureScreenShotWithTestStepName(driver, "urlopened");
		    String filepath =	CaptureScreenshotUsingRobot.CaptureScreenShotWithTestStepNameUsingRobotClass("faildeurlopened");
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
			System.out.println("Screenshot taken");
			logger.log(Status.INFO, "ULRopenend case info");
			logger.log(Status.FAIL, "ULRopenend case failled");
			
		}
		else {
			 String filepath =	CaptureScreenshotUsingRobot.CaptureScreenShotWithTestStepNameUsingRobotClass("faildeurlopened");
			logger.pass(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
		}
		
		extent.flush();
		driver.quit();
		
	}
			
	

}
