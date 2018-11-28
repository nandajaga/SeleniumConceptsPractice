package seleniumSession;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleUsingTitle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		Windowhandle("Home");
	}

	//Switch Window with the help of page title
	public static void Windowhandle(String title) throws InterruptedException {
		System.out.println("control in Details page");
	 Set<String> allWindows1= driver.getWindowHandles();
		
		if(!allWindows1.isEmpty()) {
			for(String WindowID:allWindows1) {
				try {
				if(driver.switchTo().window(WindowID).getTitle().equals(title)) {
						System.out.println("Title is : "+driver.getTitle());
						Thread.sleep(3000);
						break; //used to come out of loop and continue execution
					}
				}catch(org.openqa.selenium.NoSuchWindowException e){
						e.printStackTrace();
					}
									
				}
			}

	}
}
