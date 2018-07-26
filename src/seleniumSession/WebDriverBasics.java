package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//FF
		/*System.setProperty("webdriver.gecko.driver", "C://Users//ab54030//Desktop//NandaSelenium//geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.seleniumhq.org/download/");*/
		
		//chrome
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.seleniumhq.org/download/");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
