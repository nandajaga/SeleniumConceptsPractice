package seleniumSession;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IeDriverTest {
	static WebDriver driver;

	public static void main(String[] args) {

		//1. working 
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("requireWindowFocus", true);  
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);		
		String driverpath="src/Drivers/IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver",driverpath);
		InternetExplorerDriver driver= new InternetExplorerDriver(capabilities);
		
		//2
		/*System.setProperty("webdriver.ie.driver", "C:\\Users\\ab54030\\Desktop\\NandaSelenium\\IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		@SuppressWarnings("deprecation")
		InternetExplorerDriver  driver = new InternetExplorerDriver(ieCapabilities);*/
		
		//3
	/*	String service = "C:\\Users\\ab54030\\Desktop\\NandaSelenium\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", service);
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		InternetExplorerDriver  driver = new InternetExplorerDriver(ieCapabilities);*/
		//driver.navigate().to("http://example.com");
		
		
		//4
		
		/* ###################working ################
		 * File file = new File("C://Users//ab54030//Documents//My Received Files//IEDriverServer.exe");
		DesiredCapabilities ieCapabilities=DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability("nativeEvents",false);
		ieCapabilities.setCapability("unexpectedAlertBehaviour","accept");
		ieCapabilities.setCapability("ignoreProtectedModeSettings",true);
		ieCapabilities.setCapability("disable-popup-blocking",true);
		ieCapabilities.setCapability("PersistentHover",false);
		ieCapabilities.setCapability("RequireWindowFocus ", true);
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		//System.setProperty("webdriver.ie.driver","C://Users//ab54030//Documents//My Received Files//IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath() );
		driver=new InternetExplorerDriver(ieCapabilities); ########*/
		
		driver.get("https://www.linkedin.com/");
		System.out.println("initial page title is : " + driver.getTitle());

		driver.findElement(By.id("login-email")).sendKeys("nnanda.kumar");
		driver.findElement(By.id("login-password")).sendKeys(("test@123"));
		driver.findElement(By.id("login-submit")).click();

		System.out.println("After Login click title is: " + driver.getTitle());				
		driver.close();
	}

}
