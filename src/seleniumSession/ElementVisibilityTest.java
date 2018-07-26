package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
				
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/register/");
		
		// isDisplayed()--> used for all elements 
		boolean b1= driver.findElement(By.id("submitButton")).isDisplayed(); // for submit button 
		System.out.println(b1); // true
		
		//isEnabled() --> primarily used for buttons 
		boolean b2= driver.findElement(By.id("submitButton")).isEnabled(); // for submit button 
		System.out.println(b2); //false
		
		//isSelcted() is applicable for check box, radio button , drop down 
		
		boolean b3= driver.findElement(By.name("agreeTerms")).isSelected(); // for submit button 
		System.out.println(b3); //false
	}

}
