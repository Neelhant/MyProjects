package Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TakesScreenshotUsingJavascriptexeFullPage {

	private static final String String = null;
	WebDriver driver;

	@Test
	public static String CaptureScreenShotWithTestStepName(WebDriver driver, String testStepsName) {
		try {
			// down casting WebDriver to use getScreenshotAs method.
			TakesScreenshot ts = (TakesScreenshot) driver;
			// capturing screen shot as output type file
			File screenshotSRC = ts.getScreenshotAs(OutputType.FILE);
			// Defining path and extension of image
			String path = System.getProperty("user.dir") + "/ScreenShot/" + testStepsName + System.currentTimeMillis()
					+ ".png";
			// copying file from temp folder to desired location
			File screenshotDest = new File(path);
			FileUtils.copyFile(screenshotSRC, screenshotDest);
			return path;

		} catch (Exception e) {
			System.out.println("Some exception occured." + e.getMessage());
			return "";
		}
	}

	@Test
	public String javascriptexe() throws InterruptedException {

		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// It returns height of view part. You can say it as page height. When you click
		// on page down key
		// Page scroll by one page.
		long pageHeight = (Long) js.executeScript("return window.innerHeight");
		System.out.println("Page height: " + pageHeight);

		// It is how much you can scroll. It is height if you scroll, you will reach to
		// bottom of page.
		long scrollableHeight = (Long) js.executeScript("return document.body.scrollHeight");
		System.out.println("Total scrollable height: " + scrollableHeight);

		// Finding number of pages. Adding 1 extra to consider decimal part.
		int numberOfPages = (int) (scrollableHeight / pageHeight) + 1;

		System.out.println("Total pages: " + numberOfPages);

		// Now scrolling page by page
		for (int i = 0; i < numberOfPages; i++) {
			TakesScreenshotUsingJavascriptexeFullPage.CaptureScreenShotWithTestStepName(driver, "Page " + (i + 1));
			js.executeScript("window.scrollBy(0," + pageHeight + ")");
			System.out.println("Taken Screenshot");
			Thread.sleep(2000);
		}
		return String;

	}

}
