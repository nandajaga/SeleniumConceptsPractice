package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
    
	// precondition annotations -starting with @Before
	
	@BeforeSuite // Annotation execution sequence 1
	public void setUp(){
		System.out.println("Setup system property for chrome browser");
	}
	
	@BeforeTest //2
	public void launchBrowser(){
		System.out.println("Launch the browser");
	}
	
	@BeforeClass // 3
	public void eneterURL(){
		System.out.println("enter URL");
	}
	
	@BeforeMethod //4
	public void login(){
		System.out.println("Login Method");
		
	}
	
	/*
	 * Execution order for first @Test
	 * 
	 *  @beforeMethod
	 *  @Test
	 *  @AfterMethod
	 *  
	 *  again for second @test
	 *  @beforeMethod
	 *  @Test
	 *  @afterMethod
	 */
	
	
	//Test cases- starting with @Test
	@Test(priority=1)  //5 if priority is defined it will run based on the priority number
	public void googleTitleTest(){
		System.out.println("Get google title");
	}
	
	@Test(priority=2)
	public void searchTest(){
		System.out.println("search test");
	}
	
	//post conditions - starting with @After
	@AfterMethod //6 
	public void logut(){
		System.out.println("logout from App");
	}
	
	@AfterClass //7
	public void deleteAllcookies(){
		System.out.println("deleteAllcookies");
	}
	
	@AfterTest //8
	public void closeBrowser(){
		System.out.println("closeBrowser");
	}
	
	@AfterSuite //9  Not executed this annotation but kept for reference
	public void genearteTestReport(){
		System.out.println("genearteTestReport");
	}
}
