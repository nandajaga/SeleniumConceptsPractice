package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");

		// without launching the browser script will run
		/*
		 * Headless chrome will run only if we have chrome version greater than
		 * 59 on MAC and greater than 60 in Windows system It is always good to
		 * pass the window size
		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Window-size=1400,800");// setting window size,
														// sometimes it works
														// even without setting
														// the window size. It's
														// always good to pass
														// the window size
		options.addArguments("headless"); // setting headless
		WebDriver driver = new ChromeDriver(options); // Chrome options argument
								

		driver.get("https://www.linkedin.com/");
		System.out.println("initial page title is : " + driver.getTitle());

		driver.findElement(By.id("login-email")).sendKeys("nnanda.kumar");
		driver.findElement(By.id("login-password")).sendKeys(("test@123"));
		driver.findElement(By.id("login-submit")).click();

		System.out.println("After Login click title is: " + driver.getTitle());
	}

}
