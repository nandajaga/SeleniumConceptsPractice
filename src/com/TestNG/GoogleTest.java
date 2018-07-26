package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 driver.get("https://google.com");
	}
	
	@Test
	public void title(){
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Goodle", "Title Not matched"); // Assert Validation
		
		boolean b=driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).isDisplayed();
		
		Assert.assertTrue(b);
		Assert.assertTrue(b, "not displayed"); // Assert Validation
	}
	
	@Test
	public void signIN(){
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		System.out.println("clicked on SignIn");
		String title1=driver.getTitle();
	    System.out.println(title1);
	    
	}
	
	@Test(groups="Test") // groups is used to group the TC and the reports also will be grouped under test(groups name)
	public void test(){
		System.out.println("Test");
	}
	
/*	@Test(groups="Test")
	public void test1(){
		System.out.println("Test1");
	}
	
	@Test(groups="Test")
	public void test2(){
		System.out.println("Test2");
	}
	
	@Test(groups="Test")
	public void test3(){
		System.out.println("Test3");
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
