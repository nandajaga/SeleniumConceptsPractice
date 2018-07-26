package seleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
				
		// below two waits are global waits, applicable for all elements 
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/droppable/");
		
		//1.get the total count of links on the page
				
		// all links are represented by <a> HTML tag (for input type--> HTML tag 'input' )
		
		List<WebElement> linklist= driver.findElements(By.tagName("a"));
		
		//size of linklist
		
		System.out.println(linklist.size());
		
		//2. get the text of each link on page
		
		for(int i=0; i<linklist.size(); i++){
			String LinkText= linklist.get(i).getText();
			System.out.println(LinkText);
			
		}
		}

}
