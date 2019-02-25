package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/droppable/");
		
/*		driver.switchTo().frame(0);//since only 1 frame is available in the page source	
		
		Actions action= new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).
		release().
		build().
		perform();
		
		System.out.println("DOne");*/
		
       driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
       driver.findElement(By.xpath("//*[@id='customers']/tbody")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
       Keys.chord(Keys.CONTROL,"c");
       
	}

}
