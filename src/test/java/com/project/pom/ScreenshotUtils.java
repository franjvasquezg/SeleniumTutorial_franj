package com.project.pom;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	protected WebDriver driver;

	public ScreenshotUtils(WebDriver driver) {
		this.driver = driver;
	}

	private String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return sdf.format(date);
	}

	public void screenShot(WebDriver driver) {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(
					//"./SeleniumTutotial_franj/Ss/error_" + Thread.currentThread().getStackTrace()[1].getMethodName() + getDate() + ".png"));
					"./Screenshots/error_" + Thread.currentThread().getStackTrace()[1].getMethodName() + getDate() + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
