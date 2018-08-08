package seleniumSession;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//1.
		wait.until(ExpectedConditions.titleContains("selenium"));
		//Verify Title
		assertTrue(driver.getTitle().toLowerCase().
		startsWith("selenium"));
				
	   //2.
		WebElement message = (new WebDriverWait(driver, 5))
				.until(new ExpectedCondition<WebElement>(){
				@Override
				public WebElement apply(WebDriver d) {
				return d.findElement(By.id("page4"));
				}});
	}

	
}
