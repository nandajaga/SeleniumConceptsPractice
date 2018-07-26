package com.TestNG;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=10) // invocationCount is used to execute the same TC 'n' number of times
	public void sum(){
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
	}

}
