package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class IfoAuthentication {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C://Users//ab54030//Desktop//NandaSelenium//geckodriver.exe");

		//ChromeDriver();

		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Thread.sleep(8000);

		//driver.get("http://mukeshotwani:password1234@www.engprod-charter.net/");
		driver.get("http://U1160925:ThinkVision123@ifo-env2.level3.com/");
		Thread.sleep(8000);
		//String text=driver.findElement(By.cssSelector("p")).getText();
		//System.out.println(text);


	}

}
