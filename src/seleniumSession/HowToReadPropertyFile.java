package seleniumSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HowToReadPropertyFile {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {

		
		// create a object for Properties
		Properties prop = new Properties();

		// Now pass the property file using fileInputStream(path)
		FileInputStream fs = new FileInputStream(
				"C://Users//ab54030//Desktop//NandaSelenium//SeleniumPractice//src//seleniumSession//config.properties");

		// load property file
		prop.load(fs);

		System.out.println(prop.getProperty("name"));

		String url = prop.getProperty("URL");
		System.out.println(url);

		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);

		// selecting browser based on property file
		if (BrowserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
			driver = new ChromeDriver();

		} else if (BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://Users//ab54030//Desktop//NandaSelenium//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		//reading objects and data from property 
		driver.findElement(By.id(prop.getProperty("username_id"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id(prop.getProperty("signIn_id"))).click();
		
		}

}
