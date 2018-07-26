package com.TestNG;

import org.testng.annotations.Test;

/*
 * To run all the classes we need to create an XML fine and define all the class names
 */

public class TestNGFeatures {

	@Test
	public void Login(){
		System.out.println("Logged In");
		int i=9/0;
	}
	
	//Suppose if the below 2 methods are dependent on 1st method then bu suing dependacyMethods 
	//we can skip the execution of the TC's if Login is failed
	@Test(dependsOnMethods="Login")
	public void homepage(){
		System.out.println("in Home Page");
	}
	
	@Test(dependsOnMethods="Login")
	public void sompage(){
		System.out.println("in some page");
	}
}
