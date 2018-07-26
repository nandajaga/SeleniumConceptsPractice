package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	   
	
	 WebDriver driver;
	   
	   @Test
	   @Parameters({"url","emailId"})
	   
		public void gmailLoginTest(String url, String emailId){
			
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 
		 driver.get(url);
		 driver.findElement(By.id("identifierId")).sendKeys(emailId);
		 
		 
	}
}
