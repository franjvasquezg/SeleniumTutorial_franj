package com.project.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch extends Base {

		By searchBox = By.name("q");
		By buscarConGogle = By.name("btnk");
		
		public GoogleSearch(WebDriver driver) {
			super(driver);
		}

		public void GoogleSearch() throws InterruptedException {
			clear(searchBox);
			sendKeys("GlobalR", searchBox);
			submit(searchBox);
			Thread.sleep(2000);
			
			assertEquals("GlobalR - Buscar con Google", driver.getTitle());
			
			
		}
}