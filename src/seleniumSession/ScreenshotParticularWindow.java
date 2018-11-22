package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class ScreenshotParticularWindow {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver Driver = new ChromeDriver();

		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
	
	    Driver.get("https://html.com/input-type-file/");
		
		// Xpath of element to take screen shot
		WebElement element = Driver.findElement(By.xpath("//*[@id=\"post-206\"]/header/h1/code"));
		((JavascriptExecutor) Driver).executeScript("arguments[0].style.border='3px solid red'", element);
		File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screenshot);
		int height = element.getSize().height;
		int width = element.getSize().width;

		Rectangle rect = new Rectangle(width + 100, height + 100);
		Point p = element.getLocation();
		BufferedImage dest = img.getSubimage(p.getX() - 50, p.getY() - 50, rect.width, rect.height);
		ImageIO.write(dest, "png", screenshot);

		FileUtils.copyFile(screenshot, new File("C://Users//ab54030//Desktop//NandaSelenium//SeleniumPractice//src//seleniumSession//google.png"));	}

}
