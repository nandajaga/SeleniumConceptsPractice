package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
				
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);

	    driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	    
	    // Method 1	    
/*
• Iterate row and column and get the cell value. 
• Using for loop
• Get total rows and iterate table
• Put if(string matches) then select the respective check box
• Lengthy method*/
	     
	    //*[@id='vContactsForm']/table/tbody/tr[4]/td[2]
	    //*[@id='vContactsForm']/table/tbody/tr[5]/td[2]
	    //
	    ///
	    //*[@id='vContactsForm']/table/tbody/tr[18]/td[2]
	    
	    //only row number is changing
	    
	    String before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
	    String after_xpath="]/td[2]";
	    
	    for(int row=4; row<=18; row++){
	    	String original_xpath= driver.findElement(By.xpath(before_xpath + row + after_xpath)).getText();
	    	System.out.println(original_xpath);
	    	

	    	if(original_xpath.contains("Christy Thomas")){
	    		Thread.sleep(3000);
		    	//*[@id='vContactsForm']/table/tbody/tr[18]/td[1]/input
		    	//for which we need to click on check box
	    		driver.findElement(By.xpath(".//*[@id='vContactsForm']/table/tbody/tr["+row+"]/td[1]/input")).click();
	    		System.out.println("clicked on check box");
	    	}
	    	
	/*Method – 2:
• Using custom XPath 
• Using parent and preceding-sibling tags
• No need to write for loop
• No full iteration of table
• Single line statement
• More dynamic
• Efficient and fast */ // first row check box, 2nd row has text 'avc sd' , to clcik on the check box in 1st row below xpath 
	    driver.findElement(By.xpath("//a[contains(text(),'avc sd')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'David Cris')]/parent::td//preceding-sibling::td//input[@name='contact_id'])[1]")).click();
	    }
	}

}
