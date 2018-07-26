package seleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClick {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Actions action=new Actions(driver);
		
		WebElement rightclickbtn=driver.findElement(By.cssSelector(".context-menu-one"));
		
		//contextClick() is used to right click 
		action.contextClick(rightclickbtn).build().perform();
		
		WebElement copy= driver.findElement(By.cssSelector(".context-menu-icon-copy "));
				System.out.println(copy.getText());
				copy.click();
		
				
	}

}
