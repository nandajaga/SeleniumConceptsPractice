package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*
		 * In Authentication pop up where we need to pass UN and PWD can be
		 * handled by passing UN and PWD in the URL.
		 *  Format is http://UN:PWD@URL
		 */
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String text=driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
	}

}
