package seleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionSlectionText {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
				
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
/* Handle Dynamic Search Using Dynamic XPath - Google Search:
Steps:
1. Google Search – pick a value from suggestions
2. Search using Xpath
3. Get the total count of suggestions
4. Use if condition to match the value
5. Click on matched value  */
		
		//Selecting auto text in google search 
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		
	    List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c'] "));
	  
	    System.out.println("Total auto suggestions==>"+list.size());
	    
	    for(int i=0; i<list.size(); i++){
	    	String autotexts=list.get(i).getText(); // to see the list of auto suggesting words
	    	System.out.println("The auto suggesting words are ==>"+autotexts);
	    	
	    	if(autotexts.contains("java jdk")){
	    		list.get(i).click(); // to click on any particular text in auto suggestion
	    		break; // once it found the text comes out of the loop to save time as we found what we need to click
	    	}
	    }
	
	    
	    //second example
	    driver.get("https://www.freshdirect.com/index.jsp");
	    driver.findElement(By.id("topSearchField")).sendKeys("Av");
	    List<WebElement> list1= driver.findElements(By.xpath("//ul[contains(@id, 'ui-id-')]//li"));
	    System.out.println(list1.size());
	    
	    for(int i=0; i<list1.size();i++){
	    	System.out.println(list1.get(i).getText());
	    	
	    	if(list1.get(i).getText().equals("alligator avocados")){
	    		list1.get(i).click();
	    		break;
	    	}
	    }
	    
	 // To click on Last auto suggesting text
	    driver.get("https://www.freshdirect.com/index.jsp");
	    driver.findElement(By.id("topSearchField")).sendKeys("Av");
	    List<WebElement> list2= driver.findElements(By.xpath("//ul[contains(@id, 'ui-id-')]//li"));
	    System.out.println(list2.size());  
	    list2.get(list2.size()-1).click();
	}

}
