package com.TestNG.parallelExecution;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecutionBrowser {

	 	
	@Test
	  public void parallelTest1() {
	      //WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	      String baseWebUrl = "https://www.facebook.com/";
	      driver.get(baseWebUrl);
	      Assert.assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
	      driver.getTitle();
	      driver.close();
	  }
	  @Test
	  public void parallelTest2() {
	    //  WebDriver driver = new FirefoxDriver();
		     System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		     WebDriver driver= new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	      String baseWebUrl = "https://www.facebook.com/";
	      driver.get(baseWebUrl);
	      Assert.assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
	      driver.getTitle();
	      driver.close();
	  }
	  @Test
	  public void parallelTest3() {
	     // WebDriver driver = new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		  WebDriver driver= new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	      String baseWebUrl = "https://www.facebook.com/";
	      driver.get(baseWebUrl);
	      Assert.assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
	      driver.getTitle();
	      driver.close();
	  }
	
}
