package seleniumSession;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Networx {

	public static InternetExplorerDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		DesiredCapabilities ieCapabilities=DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability("nativeEvents",false);
		ieCapabilities.setCapability("unexpectedAlertBehaviour","accept");
		ieCapabilities.setCapability("ignoreProtectedModeSettings",true);
		ieCapabilities.setCapability("disable-popup-blocking",true);
		ieCapabilities.setCapability("PersistentHover",false);
		ieCapabilities.setCapability("RequireWindowFocus ", true);
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			
		try {
		ieCapabilities.setCapability("initialBrowserUrl","https://controlnetworx-itv1.centurylink.com/");
		String driverpath="src/Drivers/IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver",driverpath);
		driver= new InternetExplorerDriver(ieCapabilities);
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();

    	System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//Login Page
		Thread.sleep(5000);

		driver.findElement(By.xpath("//td//input[@name='logon']")).sendKeys("netextuser");
		driver.findElement(By.id("password")).sendKeys("netextuser");
		Thread.sleep(2000);
		driver.findElement(By.name("Submit223")).click();
		
		Thread.sleep(5000);

		//Accepting Alert  
		Alert alert=driver.switchTo().alert();
		Thread.sleep(5000);
		System.out.println(alert.getText());
		alert.accept(); 
		Thread.sleep(5000);
		
		//selecting contract type
		String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)                  
        {
            if(!windowHandle.equals(parentWindow))
               
           {
               driver.switchTo().window(windowHandle);
            driver.switchTo().window(windowHandle).findElement(org.openqa.selenium.By.xpath(".//*[@id='contracttype1']")).click();
               }
                        
            }
        
        //driver.switchTo().window(parentWindow);
        Thread.sleep(2000); 
        System.out.println("Contract type: UNIVERSAL Selected");
        Thread.sleep(5000); 
	//Home Page
    	/*WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement ordering;
        ordering= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//a//font[contains(text(),'ORDERING')]")));
        ordering.click();*/
        driver.findElement(By.xpath("//a//font[contains(text(),'ORDERING')]")).click();
        
        System.out.println("ordering");

		  
		
		}
		
		//driver closing
		finally {
		driver.close();
		driver.quit();
		driver=null;	
		}
	}

}
