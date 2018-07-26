package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://www.spicejet.com/");
		Thread.sleep(5000);
		//mouse over drop down
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(5000);

		driver.findElement(By.linkText("Hot Meals")).click();
		
		System.out.println("done");
		Thread.sleep(3000);

		//more than 1 mousehover----> not worked when i done the below step 
		action.moveToElement(driver.findElement(By.id("Login"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='menu-list-login']/li[1]/a"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='menu-list-login']/li[1]/ul/li[1]/a")).click();
		
		System.out.println("2nd mouse over done");
	}

}
	