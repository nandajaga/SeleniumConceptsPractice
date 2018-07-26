package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorHighlighter {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.linkedin.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("login-email")).sendKeys("nnanda.kumar");
		driver.findElement(By.id("login-password")).sendKeys(("test@123"));
		WebElement signinBTN=driver.findElement(By.id("login-submit"));
		flash(signinBTN, driver);
		System.out.println("done");
	}

	  /*Highlight element in Selenium using JavaScriptExecutor:
       +Must have feature Highlight element Selenium for better execution.
        In Automation, testing sometimes element highlighter plays very important role. 
        It helps us to track our execution flow which step is being processed. Some tools like QTP, Sahi etc. you will get this inbuilt feature. 

      For Selenium, we have to write small code, which simply highlights element based on our parameter values.Selenium Highlights using CSS values.
      In Selenium, we can use JavascriptExecutor (interface) to execute Javascript code into webdriver.*/
	
	public static void flash(WebElement element, WebDriver driver){
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		String bgcolor= element.getCssValue("backgroundcolor");
		for(int i=0; i<100; i++){ //highlighting for 100 times
			changecolor("rgb(255,0,0)",element, driver); //1
			changecolor(bgcolor,element, driver);//2
		}
	}

	private static void changecolor(String color, WebElement element, WebDriver driver) {

		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundcolor= '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
