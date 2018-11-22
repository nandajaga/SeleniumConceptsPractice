package seleniumSession;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class Imdb {

	static WebDriver driver;
	String WikiDirectorName;
	String ImdbDirectorName;
	List<String> Imdblink1;
	List<String> wikilink;
	List<String> ListWikiDirectorName;
	List<String> listgetDirectornameImdb;
	String MovieNumber;
	String MovieName;
	WebElement wiki;

	@DataProvider()
	public Object[][] DataInput() throws Exception {

		Object[][] retObjArr = com.ExcelReader.Excel.getTableArray("C:\\Users\\AB54030\\Desktop\\NandaSelenium\\ImdbMovie.xls",
				"Sheet3", "DataInput");
		System.out.println(retObjArr);
		return (retObjArr);
	};

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "DataInput")
	public void IMDB(String MovieNo, String MovieName1) throws InterruptedException {
		System.out.println("MovieNo :" + MovieNo);
		System.out.println("Movie Name :" + MovieName1);
		MovieNumber = MovieNo;
		MovieName = MovieName1;
		Thread.sleep(3000);
		getWikiLinkInGoogleSearch();
		getDirectornameWiki();
		getImdbLinkInWikiPage();
		getDirectornameImdb();
		Dirnameverify();
	}

	/*
	 * @Test(dataProvider = "DataInput") public void IMDB1(String MovieNo, String
	 * MovieName) throws InterruptedException { System.out.println("MovieNo :" +
	 * MovieNo); System.out.println("Movie Name :" + MovieName);
	 * driver.findElement(By.id("lst-ib")).sendKeys(MovieName); Thread.sleep(3000);
	 * getWikiLinkInGoogleSearch();
	 * 
	 * }
	 */

	public void getWikiLinkInGoogleSearch() throws InterruptedException {
		driver.findElement(By.id("lst-ib")).sendKeys(MovieName);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		try {
			wiki = driver.findElement(By.xpath("(//a[contains(@href,'https://en.wikipedia.org/wiki/')])[1]"));

		} catch (NoSuchElementException e) {
			System.out.println("##############################################");
			System.out.println("'" + MovieName + "' is not a movie name");
			System.out.println("##############################################");
			//driver.quit();
			//System.exit(1);

		}
		wikilink = new ArrayList<>();
		wikilink.add(wiki.getAttribute("href"));
		wiki.click();
		for (String list1 : wikilink) {
			System.out.println("wiki Link" + list1);
		}
	}

	public void getDirectornameWiki() {
		WebElement WikiDirector = driver.findElement(By.xpath("//table[@class='infobox vevent']//tbody//tr[3]//td"));
		WikiDirectorName = WikiDirector.getText();
		ListWikiDirectorName = new ArrayList<>();
		ListWikiDirectorName.add(WikiDirectorName);
		for (String list2 : ListWikiDirectorName) {
			System.out.println("WikiDirectorName: " + list2);
		}
	}

	public void getImdbLinkInWikiPage() throws InterruptedException {

		// IMDB link
		Thread.sleep(3000);
		WebElement Imdblink = driver.findElement(By.xpath("//li/a[contains(@href,'https://www.imdb.com/title')]"));
		// System.out.println(Imdblink.getText());
		// System.out.println(Imdblink.getAttribute("href"));
		Imdblink1 = new ArrayList<>();
		Imdblink1.add(Imdblink.getAttribute("href"));
		for (String list2 : Imdblink1) {
			System.out.println("Imdblink :" + list2);
		}
		Imdblink.click();
		Thread.sleep(3000);
	}

	public void getDirectornameImdb() {
		WebElement ImdbDirector = driver.findElement(By.xpath("(//div[@class='credit_summary_item']//a)[1]"));
		ImdbDirectorName = ImdbDirector.getText();
		System.out.println(ImdbDirectorName);
		listgetDirectornameImdb = new ArrayList<>();
		listgetDirectornameImdb.add(ImdbDirectorName);
		for (String list2 : listgetDirectornameImdb) {
			System.out.println("ImdbDirector: " + list2);
		}
	}

	public void Dirnameverify() {
		assertEquals(ListWikiDirectorName, listgetDirectornameImdb);
		assertTrue(WikiDirectorName.equals(ImdbDirectorName));
		System.out.println("######################################################");
		System.out.println(MovieNumber + ":" + MovieName);
		System.out.println("WikiDirectorName :" + WikiDirectorName + "IMDBDirectorName : " + ImdbDirectorName);
		System.out.println("wikilink : " + wikilink);
		System.out.println("Imdblink : " + Imdblink1);
		System.out.println("######################################################");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		driver = null;

	}

}
