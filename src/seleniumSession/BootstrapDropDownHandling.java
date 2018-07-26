package seleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDownHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		// The below method is used for which the drop down HTML element is not select 
		//finding all the elements in drop down
		List<WebElement> list=	driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//li//a//label"));
		
		System.out.println(list.size());
		// To select a particular value in drop down
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Angular")){
				list.get(i).click();
				break;
			}
			
	   /* // to select all values in drop down
			for(int i=0; i<list.size();i++){
				System.out.println(list.get(i).getText());
				list.get(i).click();
				}*/
		
	}
 
	}
}
