package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ExcelTestData {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	//private String height;
	//private String weight;
	private String bmi;
	private String bmiCategory;
	private String error;
	private String UN;
	private String PWD;


	@Parameters
	public static Collection testData() throws Exception {
		InputStream spreadsheet = new FileInputStream("C:\\Users\\ab54030\\Desktop\\Data.xlsx");
		return new SpreadsheetData(spreadsheet).getData();
	}

	public ExcelTestData(String UN, String PWD, String bmi, String bmiCategory, String error) {
		this.UN = UN;
		this.PWD = PWD;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
		this.error = error;
	}

@BeforeClass
public static void setUp() throws Exception {
// Create a new instance of the Chrome driver
	System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");

driver = new ChromeDriver();
driver.get("https://www.linkedin.com/");
}

	@Test

	public void testBMICalculator() throws Exception {
		try {
			WebElement UNField = driver.findElement(By.id("login-email"));
			UNField.clear();
			if (!UN.equals("<Blank>"))
				UNField.sendKeys(this.UN);
			WebElement PWDField = driver.findElement(By.id("login-password"));
			PWDField.clear();
				PWDField.sendKeys(this.PWD);
			WebElement signINButton = driver.findElement(By.id("login-submit"));
			signINButton.click();
			if (error.equals("<Blank>")) {
				WebElement bmiField = driver.findElement(By.name("bmi"));
				assertEquals(this.bmi, bmiField.getAttribute("value"));
				WebElement bmiCategoryField = driver.findElement(By.name("bmi_category"));
				assertEquals(this.bmiCategory, bmiCategoryField.getAttribute("value"));
			}

			else {
				WebElement errorLabel = driver.findElement(By.id("error"));
				assertEquals(this.error, errorLabel.getText());
			}
		} catch (Error e) {
//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
//Close the browser
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}