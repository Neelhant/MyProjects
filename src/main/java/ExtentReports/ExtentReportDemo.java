package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.*;
//import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.LogStatus;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	
	
	
	         // Create global variable which will be used in all method
		public ExtentReports extent;
		public ExtentTest logger;
		public WebDriver driver;
		
	        // This code will run before executing any testcase
		@BeforeMethod
		public void setup()
		{
		    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./ExtentReportsfile/learn_automation4.html");
			
		   
		   extent = new ExtentReports();
		//    logger.startTest(testName);
		    
		    extent.attachReporter(reporter);
		    
		    
		    logger=extent.createTest("LoginTest");
		    logger.log(Status.INFO, "gf df");
		    
		   
		    
		   
		}

}
