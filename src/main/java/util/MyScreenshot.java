package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MyScreenshot {

	public String takescreenshot(WebDriver driver) {

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationfile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "myNewFile.png");

		try {
			FileUtils.copyFile(srcfile, destinationfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationfile.getAbsolutePath();
	}

}
