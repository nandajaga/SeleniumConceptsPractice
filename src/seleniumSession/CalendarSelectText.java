package seleniumSession;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectText {

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
		
		driver.findElement(By.xpath("//a[@title='Calendar']")).click();

		/*
		 * Steps to handle calendar in Selenium Webdriver:
		 1- Click on calendar
		 2- Get all td of tables using findElements method
		 3- using for loop get text of all elements
		 4- using if else condition we will check specific date
		 5- If date is matched then click and break the loop. 
		 6- Handle NoSuchElementException in case of (31st day)
		 */
		String date="31-July-2019";
		String dateArray[]=date.split("-");
		
		String dateSelect=dateArray[0];
		String Month=dateArray[1];
		String year=dateArray[2];
		
		//Selecting Month
		Select monddl= new Select(driver.findElement(By.name("slctMonth")));
		monddl.selectByVisibleText(Month);
		//Selecting Year
		Select yearddl=new Select(driver.findElement(By.name("slctYear")));
		yearddl.selectByVisibleText(year);
		
		//Selecting Date
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		//......so on
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		//.....
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]
		 //here the row and column are changing (total row is 7 and column would be 7 as no. of weekdays)
		
		String before_xpath="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath="]/td[";
		
		final int totalWeekDays=7;
		boolean flag=false;
		String orgDay = null;

		for(int row=2; row<=6; row++){
			for(int column=1; column<=totalWeekDays; column++){
								
				try {
					orgDay = driver.findElement(By.xpath(before_xpath + row + after_xpath + column +"]")).getText();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Please enter a correct date value");
					flag=false;
					break;
				}
				System.out.println(orgDay);
				if(orgDay.equals(dateSelect)){
					driver.findElement(By.xpath(before_xpath + row + after_xpath + column +"]")).click();
					flag=true;
					break;
					
				}
				if(flag){
					break;
				}
			}
		}
		}

}
