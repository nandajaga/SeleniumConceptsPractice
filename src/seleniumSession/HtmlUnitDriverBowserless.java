package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverBowserless {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		
		/* HtmtUnitDriver is not available in selenium v3.X - need to add jars manually
		 * It is also know as Headless Browser, Ghost driver-- testing happens behind the scene (It will not open browser during execution)
		 * Not useful for Action class-- mouse over, double click, drag and drop 
		 * Very fast compared to other ways of execution 
		 * Headless browsers --1)HtmlUnitDriver --> Java
		 *                     2) PhantomJs ---> Javascript*/
		
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("https://www.linkedin.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("login-email")).sendKeys("nnanda.kumar");
		driver.findElement(By.id("login-password")).sendKeys(("test@123"));
		driver.findElement(By.id("login-submit")).click();
		
		System.out.println(driver.getTitle());
	}

}
