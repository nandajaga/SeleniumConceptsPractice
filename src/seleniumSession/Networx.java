package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Networx {

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("requireWindowFocus", true);  
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);		
		String driverpath="src/Drivers/IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver",driverpath);
		InternetExplorerDriver driver= new InternetExplorerDriver(capabilities);
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://controlnetworx-itv1.centurylink.com/portal/site/networx/menuitem.c6e563d9c06dea1088928310b87c00a0/");
		
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userId")));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
/*		driver.findElement(By.id("userId")).sendKeys("netextuser");
		driver.findElement(By.id("password")).sendKeys("netextuser");
		Thread.sleep(2000);
		driver.findElement(By.name("Submit223")).click();
	*/
		
	}

}
