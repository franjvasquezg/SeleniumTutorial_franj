package com.project.pom;
//package com.selenium.tutorial;

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatosPageKatalom2 extends Base {
	
	public DatosPageKatalom2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By searchBox = By.name("q");
	By buscarKatalom = By.name("username");

	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		driver.findElement(By.linkText("Username"));
		driver.findElement(By.linkText("Password"));
		driver.findElement(By.linkText("Login")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(driver.getTitle());


	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
