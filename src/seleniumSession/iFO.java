package seleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class iFO {

	static InternetExplorerDriver driver;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 * capabilities.setCapability(InternetExplorerDriver.
		 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); String
		 * driverpath="src/Drivers/IEDriverServer.exe"; // change the path as per your
		 * local system System.setProperty("webdriver.ie.driver",driverpath);
		 * InternetExplorerDriver driver= new InternetExplorerDriver(capabilities);
		 */

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://ifo-env2.level3.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/ucommand/CRM/Employee/DelegateMaintenance.aspx']")).click();

		Thread.sleep(5000);
		WebElement Switch = driver.findElement(By.id("ctl09_TestDelegateSwitchCtrl_ddImpersonations"));
		Thread.sleep(2000);
		Select Switch1 = new Select(Switch);
		Switch1.selectByVisibleText("TestEntr - Enterprise Sales Rep");
		driver.findElement(By.xpath(".//*[@value='Switch']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(.//*[@title='View Company Details'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@value='Create Quote']")).click();
		driver.findElement(By.xpath(".//*[@type='text']")).sendKeys("Quote");
		driver.findElement(By.xpath(".//*[@type='submit']")).click();
		Thread.sleep(2000);
		WebElement product = driver
				.findElement(By.id("OrderBaseCtrl_GXHyperLinkTab_ProductPickerCtrl_PickerCtrl_ctl00_ProductFamilyDDL"));
		Thread.sleep(2000);
		Select product1 = new Select(product);
		product1.selectByVisibleText("Dedicated Internet");
		Thread.sleep(2000);
		WebElement region = driver.findElement(
				By.id("OrderBaseCtrl_GXHyperLinkTab_ProductPickerCtrl_PickerCtrl_DecisionTreeCtrl_DdAnswers56"));
		Thread.sleep(2000);
		Select region1 = new Select(region);
		region1.selectByVisibleText("North America");
		Thread.sleep(2000);
		WebElement service = driver.findElement(By
				.id("OrderBaseCtrl_GXHyperLinkTab_ProductPickerCtrl_PickerCtrl_DecisionTreeCtrl_DTL5657_DdAnswers57"));
		Thread.sleep(2000);
		Select service1 = new Select(service);
		service1.selectByVisibleText("No");
		Thread.sleep(2000);
		WebElement circuit = driver.findElement(By.id(
				"OrderBaseCtrl_GXHyperLinkTab_ProductPickerCtrl_PickerCtrl_DecisionTreeCtrl_DTL5657_DTL57112_DdAnswers112"));
		Thread.sleep(2000);
		Select circuit1 = new Select(circuit);
		circuit1.selectByVisibleText("No");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(.//*[@type='text'])[2]")).sendKeys("DNVRCOMA");

		Thread.sleep(8000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@class='ui-corner-all']/table"))).build().perform();
		driver.findElement(By.partialLinkText("[L3 POP]-[PHYSICAL LEC]-[COMPLETE]")).click();

		Thread.sleep(3000);
		WebElement BW = driver.findElement(By.xpath("//select[contains(@id,'_ProductLocationSelectA_LocationABandwidth')]"));
		Select BW1 = new Select(BW);
		BW1.selectByVisibleText("T1 (1.5 Mb)");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//tr[@class='GXDataGridAlternatingItemStyle']//td)[1]")).click();
		Thread.sleep(6000);	
		//WebElement billingmethod = driver.findElement(By.xpath("//select[contains(@id,'ProductLocationItemsA_ProductCategoryCtl889A0_ctrl_CatalogMarketedServiceElementId2464_0_00000000000_ctl02')]"));
		WebElement billingmethod = driver.findElement(By.xpath("//select[contains(@id,'ctrl_CatalogMarketedServiceElementId2464_0_00000000000_ctl02')]"));
		System.out.println("clicked");
		Thread.sleep(5000);
		Select billingmethod1 = new Select(billingmethod);
		billingmethod1.selectByVisibleText("Usage");
		Thread.sleep(8000);
		WebElement CDR=driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]"));
		CDR.sendKeys("3.0");
		CDR.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		System.out.println("Saved");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//input[@value='Finish']")).click();
		
		driver.close();
		driver.quit();
		driver=null;

	}
}
