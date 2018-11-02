package Utility;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CaptureScreenshotUsingRobot {

	public static String CaptureScreenShotWithTestStepNameUsingRobotClass(String testStepsName)
			throws AWTException, IOException {

		// Creating Robot class object
		Robot robotClassObject = new Robot();

		// Get screen size
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		// Capturing screenshot by providing size
		BufferedImage tmp = robotClassObject.createScreenCapture(screenSize);

		// Defining destination file path
		String path = System.getProperty("user.dir") + "/Screenshot/" + testStepsName + System.currentTimeMillis()
				+ ".png";

		// To copy temp image in to permanent file
		ImageIO.write(tmp, "png", new File(path));
		return path;

	}

}
