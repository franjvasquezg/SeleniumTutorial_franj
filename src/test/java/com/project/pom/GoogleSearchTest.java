package com.project.pom;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class GoogleSearchTest {

	private WebDriver driver;

	GoogleSearch googleSearch;
	ScreenshotUtils screenshot;

	@BeforeClass
	public void beforeClass() {
		googleSearch = new GoogleSearch(driver);
		driver = googleSearch.chromeDriverConnection();
		googleSearch.visit("https://www.google.co.ve/");
	}

	@Test
	public void testGoogleSearch() throws InterruptedException, IOException {
		googleSearch.GoogleSearch();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			screenshot = new ScreenshotUtils(driver);
			screenshot.screenShot(driver);
		}
		driver.quit();
	}

}