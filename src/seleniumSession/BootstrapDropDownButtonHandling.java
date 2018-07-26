package seleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDownButtonHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// The below method is used for which the drop down HTML element is not select 
		driver.get("http://v4-alpha.getbootstrap.com/components/dropdowns/");
		driver.findElement(By.id("dropdownMenuButton")).click();
		
       List<WebElement> list= driver.findElements(By.xpath("//div[ (@class='dropdown-menu') and (@aria-labelledby='dropdownMenuButton')]//a"));
        System.out.println(list.size());
        
        for(int i=0; i<list.size();i++){
			System.out.println(list.get(i).getText());
			Thread.sleep(3000);
			if(list.get(i).getText().contains("Something else here")){
				list.get(i).click();
				break;
			}
	}
	}
}
