package seleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
	   Alert alert=driver.switchTo().alert();
	   String text=alert.getText();
	   System.out.println(text);
	   
	   if(text.equals("Please enter a valid user name")){
		   System.out.println("correct alert msg");
	   }else{
		   System.out.println("In-correct alert msg");
	   }
	   alert.accept(); // click on OK btn
	  // alert.dismiss(); // click on cancel btn
		
	   /* The above is used for Java script pop up-- Alert API (accept/dismiss)*/
	}

}
