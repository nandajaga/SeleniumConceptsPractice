package seleniumSession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		/* Browser window Pop up, Advertisement pop up--> WindowHandler API- getWindowHandles()*/
		Set<String> handler=driver.getWindowHandles();
		
		Iterator<String> it=handler.iterator();
		
		String parentwindow= it.next();
		System.out.println("Parent Window is :"+parentwindow);
		
		String childwindow= it.next();
		System.out.println("child Window is :"+childwindow);
		
		driver.switchTo().window(childwindow); //switch to child 
		System.out.println("Child Window title is:"+ driver.getTitle() );
		
		driver.close(); // closing child window
		
		driver.switchTo().window(parentwindow);//switch back to parent
		System.out.println("parent window  title is:"+ driver.getTitle() );

	}

}
