package seleniumSession;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisableImagesOptions {

	public static void main(String[] args) {
		
		//chrome
/*		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		disableImagesinChrome(options);
		WebDriver driver= new ChromeDriver(options);
		driver.get("http://www.amazon.in");
		System.out.println(driver.getTitle());*/
		
		//firefox
		System.setProperty("webdriver.gecko.driver", "C://Users//ab54030//Desktop//NandaSelenium//geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		disableImagesinfirefox(options);
		WebDriver driver=new FirefoxDriver(options);
		driver.get("http://www.amazon.in");
		System.out.println(driver.getTitle());
		
	}

	//chrome browser
	public static void disableImagesinChrome(ChromeOptions options) {
		//It will disable the images , so that the script execution will be fast
		HashMap<String, Object> images= new HashMap<String, Object>();
		images.put("images", 2);
		HashMap<String, Object> prefs= new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images); // property values are provided by chrome browser
		options.setExperimentalOption("prefs", prefs);
	}
	
	//FF browser
	public static void disableImagesinfirefox(FirefoxOptions options) {
		//It will disable the images , so that the script execution will be fast
		FirefoxProfile profile= new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		
		
	}
}

