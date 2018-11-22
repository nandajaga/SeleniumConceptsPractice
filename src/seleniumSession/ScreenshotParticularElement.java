package seleniumSession;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenshotParticularElement {

	@Test
	public void screenShotElement() throws IOException {
		
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		
		driver.manage().window().maximize();
		// Xpath of element to take screen shot
		WebElement element = driver.findElement(By.xpath("//*[@id=\"post-206\"]/header/h1/code"));
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Take full screen screenshot
		
		BufferedImage fullImg = ImageIO.read(screenshot);
		Point point = element.getLocation();
		int elementWidth = element.getSize().getWidth();
		int elementHeight = element.getSize().getHeight();
		BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight); // crop
																														// the
																														// image
																														// to
																														// required
		ImageIO.write(elementScreenshot, "png", screenshot);
		FileUtils.copyFile(screenshot, new File("mostread_screenshot.png"));// path to save screen shot driver.close();
																			// }
	}
}
