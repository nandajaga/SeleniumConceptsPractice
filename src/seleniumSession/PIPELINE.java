package seleniumSession;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PIPELINE {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		//Passing the AutoIt Script here 
		//Runtime.getRuntime().exec("C:\\Users\\AB54030\\Downloads\\my_file1.exe");

		driver.get("http://U1160925:ThinkVision123@pipeline-env2/");

	}

}
