package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.linkedin.com/");
		//1.xpath
		driver.findElement(By.xpath("//*[@id='reg-firstname']")).sendKeys("nanda");
		
		//2. CSS (id -->use #, for class --> use . )
		driver.findElement(By.cssSelector("#reg-lastname")).sendKeys("Kumar");
		System.out.println("Control here");
		//3.Id
		//4.class name
		//5.link text
		//6.partial link text
		//7.name
		
		//driver.quit();
	}

}
