package org.selenium.maven.MavenTest;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenTest {
	
	static WebDriver driver;
	
	@BeforeClass
	
	public static void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\MavenTest\\driver\\chromedriver.exe");
		 driver =new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Before
	public void startDate() 
	{
		Date date = new Date();
		System.out.println(date);
	}
	
	@After
	public void endTime() {
		Date date = new Date();
		System.out.println(date);	
	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.close();

	}
	
	@Test
	public void sendText() {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("naukri");
		
	}
	
	
	
	

}
