package seleniumSession;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoIt {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		 driver = new FirefoxDriver();
		// WebDriver driver= new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(5000);

		Runtime.getRuntime().exec("C:\\Users\\ab54030\\Desktop\\NandaSelenium\\Auth.exe");

		driver.get(" http://pipeline-env3/");

		Thread.sleep(5000);
		nextstep();
		//driver.findElement(By.linkText("Change User")).click();

		driver.close();
		driver.quit();

	}

	public static void nextstep() {
		driver.findElement(By.linkText("Change User")).click();

	}
}
