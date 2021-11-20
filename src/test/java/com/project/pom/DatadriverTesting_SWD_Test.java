package com.project.pom;

//import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class DatadriverTesting_SWD_Test {
	
	
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");

	GoogleSearch googleSearch;
	ScreenshotUtils screenshot;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com");
	}

	@After
	public void tearDown() throws Exception {
		screenshot = new ScreenshotUtils(driver);
		screenshot.screenShot(driver);
		driver.quit();
	}


	@Test
	public void test() throws IOException {
		
		for (String j : Arrays.asList("Tops", "Dresses")) {
            System.out.println(j);
        
			for (int i = 0; i <= 4; i++) {
				System.out.println(i);
				String filepath = ("C:\\Users\\franjvas\\Desktop\\Test.xlsx");
				String searchText = readFile.getCellValue(filepath, j, i, 0);
				//driver.findElement(searchBoxLocator).clear();
				driver.findElement(searchBoxLocator).sendKeys(searchText);
				driver.findElement(searchBtnLocator).click();
				String resultText = driver.findElement(resultTextLocator).getText();
				System.out.println("PAge resull text: " + resultText);
				
				readFile.readExcel(filepath, j);
				writeFile.writeCellValue(filepath, j,i,1, resultText);
				readFile.readExcel(filepath,  j);
			}
		
		}
		
	}


}
