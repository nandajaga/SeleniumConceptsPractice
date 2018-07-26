package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalenderSelectByJavaScript {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://www.spicejet.com/");
		
		WebElement date= driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		
		String dateVal="30-07-2018"; //the date passing here is not selecting in UI
		selectDateByJS(driver, date, dateVal);
	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue ){
		JavascriptExecutor Js= ((JavascriptExecutor)driver);
		Js.executeScript("arguments[0].setAttribute('value', '"+dateValue+"');", element);
		
	}
}
