package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Moab {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\AB54030\\Desktop\\NandaSelenium\\SeleniumPractice\\src\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		
		 driver.get("http://U1160925:ThinkVision123@moabenv2/");
		 
		 driver.findElement(By.linkText("Order Entry")).click();
		 driver.findElement(By.xpath("//input[@value='Voice Complete']")).click();
		 driver.findElement(By.xpath("//input[@value='Next >']")).click();

		 driver.findElement(By.xpath("//input[@value='Voice Complete Install']")).click();
		 driver.findElement(By.xpath("//input[@value='Next >']")).click();

		 Thread.sleep(5000);
		 Select select= new Select(driver.findElement(By.id("ctl11_ctl03_ctl01_ctl02")));
		 select.selectByVisibleText("2-MFG7BB - Silver Ridge Asset Management US LP");
		 
		 driver.findElement(By.xpath("//input[@value='Next >']")).click();
		 driver.findElement(By.xpath("//input[@value='Next >']")).click();

		 Thread.sleep(12000);

		 Select select1= new Select(driver.findElement(By.id("ctl11_ctl03_ctl03_ctl00_ctl13")));
		 select1.selectByVisibleText("France");
		 
		 driver.findElement(By.id("ctl11_ctl03_ctl03_ctl00_ctl32_dateTextBox")).sendKeys("02/01/2019 12:00 AM");
		 
		 driver.findElement(By.xpath("//input[@value='Create Order']")).click();
		 
		 //WebElement status=driver.finde


		 
	}

}
