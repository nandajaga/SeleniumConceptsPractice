package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUpload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		
		//file upload- find the locator for Browse btn and then send keys--> local file path
		//this works only when type is FILE in HTML 	
		driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C://Users//ab54030//Desktop//NandaSelenium//Test.txt");
	
		/* FILE upload pop up --Browse button (type= FILE, Sendkeys(path)*/
	}

}
