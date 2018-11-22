package seleniumSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.firefox.FirefoxDriver;

public class SFDCTest {

	public static void main(String[] args) throws InterruptedException {

				//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
				driver.get("https://ctl--itv2.cs94.my.salesforce.com/?ec=302&startURL=%2F006%2Fo");
				driver.manage().window().maximize();
				
				// Enter Username//
				WebElement un = driver.findElement(By.xpath(".//*[@id='username']"));
				un.sendKeys("ankur.kumar@centurylink.com.itv2");
				
				// Enter Password//
				WebElement pswrd = driver.findElement(By.xpath(".//*[@id='password']"));
				pswrd.sendKeys("Century@143");
				
				// Click on Login//
				WebElement login = driver.findElement(By.xpath(".//*[@id='Login']"));
				login.click();
				
				Thread.sleep(5000);
				
//				// Click on Opportunities //
//				WebElement Opp = driver.findElement(By.xpath(".//*[@id='Opportunity_Tab']/a"));
//				Opp.click();
				
				Thread.sleep(5000);
				
				//Click on New//
				WebElement Newbtn = driver.findElement(By.xpath(".//*[@name='new']"));
				Newbtn.click();
				
				Thread.sleep(1000);	
				//Click on Continue//
				WebElement Continue = driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
				Continue.click();
				
				//Enter Accountname//
				WebElement Accountname = driver.findElement(By.xpath(".//*[@id='opp4']"));
				Accountname.sendKeys("Sunday UAT");
				
				//Enter Opportunity name//
			    WebElement Oppname = driver.findElement(By.xpath(".//*[@id='opp3']"));
				Oppname.sendKeys("Opp SFDC");
				
				//Enter Date//
			    WebElement CloseDate = driver.findElement(By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[3]/td[4]/div/span/span/a"));
			    CloseDate.click();
			    
			  //Enter Stage//
			   WebElement Stage = driver.findElement(By.xpath(".//*[@id='opp11']"));
			   Stage.click();
			    
			 //Enter Stage//
			    WebElement stage = driver.findElement(By.id("opp11"));
				Select stage1= new Select(stage);
			    stage1.selectByVisibleText("Identified");
		      
			 //Enter save//
			   WebElement save = driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]"));
			   save.click();
			   
			   Thread.sleep(5000);	
			 //Enter Legacy//
			   WebElement Legacy = driver.findElement(By.xpath(".//*[@name='legacy_level_3']"));
			   Legacy.click();	
				
			}
	

}
