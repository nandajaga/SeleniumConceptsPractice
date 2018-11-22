package seleniumSession;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class WindowHandleEON {

	public WebDriver driver;
	public String orderNo;
	public String LineItem;
	public String status;
	public String CircuitID;
	
	@Test
	public void testpopup() throws InterruptedException, IOException {
		
	
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		driver=new ChromeDriver();
		
		try {
		
		driver.get("http://qa4-eon.level3.com/eon/base/login.jsp");
		
		driver.findElement(By.name("username")).sendKeys("u1160925");
		driver.findElement(By.name("password")).sendKeys("ThinkVision123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Looged into EON");
		Thread.sleep(3000);
		
		//start of EON HOME PAGE
		String currentWindowId = driver.getWindowHandle();
	    Set<String> allWindows= driver.getWindowHandles();
		
		if(!allWindows.isEmpty()) {
			for(String WindowID:allWindows) {
				try {
				if(driver.switchTo().window(WindowID).getTitle().equals("Home")) {
					    System.out.println("*********In EON HOME PAGE**********");
						System.out.println("Title is : "+driver.getTitle());
						break; //used to come out of loop and continue execution
					}
				}catch(NoSuchWindowException e){
						e.printStackTrace();
					}
									
				}
			}
	    Thread.sleep(5000);				
		driver.switchTo().frame("workspacePane");
		System.out.println("1.Switched to Wokspacepane");
		Thread.sleep(2000);
		driver.switchTo().frame("tab_pane");
		driver.findElement(By.xpath("//td[@id='tab3_ins3']")).click();						
		System.out.println("2.Switched to TABS pane and clicked on ORDERS TAB");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("workspacePane");
		System.out.println("3.Again Switched to Wokspacepane");
		Thread.sleep(2000);
		driver.switchTo().frame("entry_pane");
		driver.findElement(By.id("toolbar_new_image")).click();
		System.out.println("4.Switched to Entry pane and clicked on NEW");
		//END of EON HOME PAGE

		Thread.sleep(2000);
		
		//switch back to order window	
	    Set<String> allWindows1= driver.getWindowHandles();
		
		if(!allWindows1.isEmpty()) {
			for(String WindowID:allWindows1) {
				try {
				if(driver.switchTo().window(WindowID).getTitle().equals("Order")) {
					    System.out.println("\n**********In ORDER PAGE**********");
						System.out.println("Title is : "+driver.getTitle());
						break; //used to come out of loop and continue execution
					}
				}catch(NoSuchWindowException e){
						e.printStackTrace();
					}
									
				}
			}
	    System.out.println("\n*************ORDER CREATION PAGE STARS HERE*************");
	    Thread.sleep(5000);	

	    driver.switchTo().frame("workspacePane");
	    System.out.println("5.Switched to Wokspacepane");
	    Thread.sleep(3000);	
	    driver.switchTo().frame("entry_pane");
	    System.out.println("6.Switched to Entry pane and clicked on NEW \n");
	    
		driver.findElement(By.id("main:accountNumber")).sendKeys("0205281309");
		
		
		WebElement orderType= driver.findElement(By.id("main:orderType"));
		fn_Select(orderType, "Customer");
		System.out.println("\n selected orderType");

		WebElement CONS= driver.findElement(By.id("main:orderNumberSuppliedFlag"));
		fn_Select(CONS, "N");
		System.out.println("\n selected Customer Order Number Supplied");

		WebElement salesType= driver.findElement(By.id("main:salesType"));
		fn_Select(salesType, "Retail");
		System.out.println("\n selected salesType");

		WebElement salesRegion= driver.findElement(By.id("main:salesRegion"));
		fn_Select(salesRegion, "North America");
		System.out.println("\n selected salesRegion");
			
		WebElement salesvertical= driver.findElement(By.id("main:salesVertical"));
		fn_Select(salesvertical, "ESD");
		System.out.println("\n selected salesvertical");

		WebElement SalesBillingEntity=driver.findElement(By.id("main:billingEntity"));
		fn_Select(SalesBillingEntity, "GC Telecommunications Inc");
		System.out.println("\n selected Billing entity");
		
		WebElement BillingSystem= driver.findElement(By.id("main:billingSystem"));
		fn_Select(BillingSystem,"BillViz");
		
		//DATE selection
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 //get current date time with Date()
		 Date date = new Date();
		 // Now format the date
		 String date1= dateFormat.format(date); 
		 // Print the Date
		 System.out.println(date1);
		
		 driver.findElement(By.id("main:receivedDateInputDate")).sendKeys(date1);
		 driver.findElement(By.id("main:signedDateInputDate")).sendKeys(date1);
			
		 //Auto selection of name in the drop down
		   driver.findElement(By.id("main:gcodContactName")).sendKeys("Naresh");
		   Thread.sleep(4000);
		  List<WebElement> autotextddl=driver.findElements(By.xpath("//table[contains(@id, 'main:j_id199:')]//td"));
		  fn_auotslectText(autotextddl,"Naresh");
			   
		   Thread.sleep(3000);
		   
		   driver.findElement(By.id("main:supportName")).sendKeys("N Nanda Kumar");
		   Thread.sleep(3000);
		   List<WebElement> SalesSupportContact=driver.findElements(By.xpath("//table[contains(@id, 'main:j_id235:')]//td"));
		   fn_auotslectText(SalesSupportContact,"Nanda");
		   
		   Thread.sleep(3000);

		   driver.findElement(By.id("main:repName")).sendKeys("N Nanda Kumar");
		   Thread.sleep(3000);
		   List<WebElement> SalesRepContact=driver.findElements(By.xpath("//table[contains(@id, 'main:j_id226:')]//td"));
		   fn_auotslectText(SalesRepContact,"Nanda");
		      	     
		
		Thread.sleep(3000);
		WebElement Drivingsystem=driver.findElement(By.id("main:drivingSystem"));
		fn_Select(Drivingsystem, "EON");
		
		WebElement DrivingAuthority= driver.findElement(By.id("main:designAuthority"));
		fn_Select(DrivingAuthority, "US Design Authority");
		
		WebElement AlternateContact=driver.findElement(By.id("main:altContactSuppliedFlag"));
		fn_Select(AlternateContact, "N");
		
		//Add Contact BTN
		driver.findElement(By.id("main:j_id256")).click();
	    Thread.sleep(5000);
	    WebElement contactType= driver.findElement(By.id("contactModal:orderContactType"));
	    fn_Select(contactType, "Primary Order Contact");
	    
	    driver.findElement(By.id("contactModal:contactFirstName")).sendKeys("Nanda");
	    driver.findElement(By.id("contactModal:contactLastName")).sendKeys("Kumar");
	    driver.findElement(By.id("contactModal:contactEmail")).sendKeys("nanda@l3.com");
	    driver.findElement(By.id("contactModal:contactPhoneNumber1")).sendKeys("4029986861");
	    driver.findElement(By.id("contactModal:saveActionButton")).click();
	    Thread.sleep(9000);
		driver.findElement(By.id("main:savebutton")).click();
	    
	    Thread.sleep(9000);
	    
	    //ITEMS TAB
	    System.out.println("\n **********************ITEMS TAB****************");
		driver.switchTo().defaultContent();
	    driver.switchTo().frame("workspacePane");
		System.out.println("\n Switched to Wokspacepane");
		Thread.sleep(2000);
		driver.switchTo().frame("tab_pane");
		driver.findElement(By.cssSelector("#tab2_ins3")).click();						
		System.out.println("\n Switched to TABS pane and clicked on ITEMS TAB");
		Thread.sleep(5000);
		//Switching frames
		driver.switchTo().defaultContent();
	    driver.switchTo().frame("workspacePane");
	    System.out.println("Switched to Wokspacepane");
	    Thread.sleep(3000);	
	    driver.switchTo().frame("entry_pane");
	    System.out.println("Switched to Entry pane \n");
	    Thread.sleep(3000);	

	    //Select the Product 
	   WebElement product= driver.findElement(By.name("newItemType"));
	   fn_Select(product, "Private Line");
	   
	   WebElement action=driver.findElement(By.name("newItemAction"));
	   fn_Select(action, "ADD");
	   
	   driver.findElement(By.cssSelector("#toolbar_add_image")).click();
	   
	 driver.switchTo().defaultContent();

	   //Switch to ITEMS window 
	   
		String ItemTAB = driver.getWindowHandle();

	    Set<String> allWindows2= driver.getWindowHandles();
		
		if(!allWindows2.isEmpty()) {
			for(String WindowID:allWindows2) {
				try {
				if(driver.switchTo().window(WindowID).getTitle().equals("Item")) {
					    System.out.println("\n**********In Item PAGE**********");
						System.out.println("\n Title is :  "+driver.getTitle());
						break; //used to come out of loop and continue execution
					}
				}catch(NoSuchWindowException e){
						e.printStackTrace();
					}
									
				}
			}
		
	    driver.switchTo().frame("workspacePane");
	    System.out.println("Switched to Wokspacepane \n");
	    Thread.sleep(2000);

	    driver.switchTo().frame("entry_pane");
	    System.out.println("Switched to Entry pane \n");
	    Thread.sleep(2000);
	   //Details TAB
	   WebElement subProfile= driver.findElement(By.id("SonetItem.fullSubProfileCode"));
	   fn_Select(subProfile, "IPL");
	   
	   WebElement capacity=driver.findElement(By.id("SonetItem.circuitCapacity"));
	   fn_Select(capacity, "100GE");
	   
	   WebElement WantDate=driver.findElement(By.id("SonetItem.wantDate"));
	   WantDate.sendKeys(date1);
	   
	   driver.findElement(By.id("LoopDates.standardIntervalDate.P")).sendKeys(date1);
	   
	   WebElement SONET=driver.findElement(By.id("SonetItem.transportTypeCode"));
	   fn_Select(SONET,"SONET");
	   
	   WebElement IRU=driver.findElement(By.id("SonetItem.revenuePtlFlag"));
	   fn_Select(IRU, "N");
	   
	   WebElement CiruitTerm=driver.findElement(By.id("SonetItem.internationalServiceRequired"));
	   fn_Select(CiruitTerm, "N");
	   
	   WebElement HotCut=driver.findElement(By.id("SonetItem.hotCutFlag"));
	   fn_Select(HotCut, "N");
	   
	   WebElement AccessCKTA=driver.findElement(By.id("VendorInterface.useExistingAccessFlag.A"));
	   fn_Select(AccessCKTA, "N");
	   
	   WebElement AccessCKTZ=driver.findElement(By.id("VendorInterface.useExistingAccessFlag.Z"));
	   fn_Select(AccessCKTZ, "N");
	   
	   WebElement popsiteA=  driver.findElement(By.id("popExternalId.A"));
	   popsiteA.sendKeys("1002030222");
	   
	   WebElement popsiteZ=  driver.findElement(By.id("popExternalId.Z"));
	   popsiteZ.sendKeys("1002030222");
	   
	   WebElement LocalLoopRequired_A=driver.findElement(By.id("VendorInterface.loopRequiredFlag.A"));
	  fn_Select(LocalLoopRequired_A, "N");
	  
	 WebElement LocalLoopRequired_Z=driver.findElement(By.id("VendorInterface.loopRequiredFlag.Z"));
	  fn_Select(LocalLoopRequired_Z, "N");
	  
	  //the below things comes automatically if the above one is selected

	  /*  WebElement GBLXA=driver.findElement(By.id("VendorInterface.vendorLoopFlag.A"));
	  fn_Select(GBLXA, "N");
	  
	  WebElement GBLXZ=driver.findElement(By.id("VendorInterface.vendorLoopFlag.Z"));
	  fn_Select(GBLXZ, "N");
	  
	  WebElement AutoOrder_A=driver.findElement(By.id("VendorInterface.loopOrderedFlag.A"));
	  fn_Select(AutoOrder_A, "N");
	  
	  WebElement AutoOrder_Z=driver.findElement(By.id("VendorInterface.loopOrderedFlag.Z"));
	  fn_Select(AutoOrder_Z, "N");*/
	  
	  WebElement TypeofAccess_A=driver.findElement(By.id("VendorInterface.accessTypeCode.A"));
	  fn_Select(TypeofAccess_A, "Cable");
	  
	  WebElement TypeofAccess_Z=driver.findElement(By.id("VendorInterface.accessTypeCode.Z"));
	  fn_Select(TypeofAccess_Z, "Cable");
	  
	  WebElement POPLocalLoop_A=driver.findElement(By.id("VendorInterface.vendorName.A"));
	  fn_Select(POPLocalLoop_A, "360networks");
	  
	  WebElement POPLocalLoop_Z=driver.findElement(By.id("VendorInterface.vendorName.Z"));
	  fn_Select(POPLocalLoop_Z, "360networks");
	  
	  WebElement Framing_A=driver.findElement(By.id("VendorInterface.framingSignallingCode.A"));
	  fn_Select(Framing_A, "N/A");
	  
	  WebElement Framing_Z=driver.findElement(By.id("VendorInterface.framingSignallingCode.Z"));
	  fn_Select(Framing_Z, "N/A");
	    
	  WebElement Protection_A=driver.findElement(By.id("VendorInterface.protectionFlag.A"));
	  fn_Select(Protection_A, "N");
	  
	  WebElement Protection_Z=driver.findElement(By.id("VendorInterface.protectionFlag.Z"));
	  fn_Select(Protection_Z, "N");
	  
	  WebElement CustomerPremAddress_A=  driver.findElement(By.id("externalId.A"));
	  CustomerPremAddress_A.sendKeys("1002030222");
	   
	  WebElement CustomerPremAddress_Z=  driver.findElement(By.id("externalId.Z"));
	  CustomerPremAddress_Z.sendKeys("1002030222");
	  
	  driver.findElement(By.id("toolbar_save_image")).click();
	  
	  Thread.sleep(5000);
	  
	  //History TAB
	  
	  System.out.println("\n **********************HISTORY TAB****************");
		driver.switchTo().defaultContent();
	    driver.switchTo().frame("workspacePane");
		System.out.println("\n Switched to Wokspacepane");
		Thread.sleep(2000);
		driver.switchTo().frame("tab_pane");
		driver.findElement(By.cssSelector("#tab3_ins3")).click();						
		System.out.println("\n Switched to TABS pane and clicked on HISTORY TAB");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
	    driver.switchTo().frame("workspacePane");
	    System.out.println("Switched to Wokspacepane");
	    Thread.sleep(3000);	
	    driver.switchTo().frame("entry_pane");
	    System.out.println("Switched to Entry pane \n");
	    Thread.sleep(3000);	

	    //complete on click(Admin), start, Refresh
	    driver.findElement(By.id("main:completeOnClick")).click();
	   
	    WebElement SaveBtn=driver.findElement(By.name("main:j_id89"));
	    SaveBtn.click();
	    Thread.sleep(2000);
	    WebElement RefreshBtn= driver.findElement(By.name("main:j_id92"));
	    RefreshBtn.click();
	    Thread.sleep(2000);
	   
	    //check order completion starts 
	    
	    
	   /* ArrayList<String> tasks=new ArrayList<>();
	    tasks.add("Check Order");
	    tasks.add("Setup Billing");
	    tasks.add("Notify Customer - Order");
	    tasks.add("Design POP-to-POP");*/
	    
	    String[] tasks1= {"Check Order","Setup Billing","Notify Customer - Order","Design POP-to-POP","Issue TR (A)","Issue TR (Z)","Build Connection (Z)",
	    		"Build Connection (A)", "Notify Customer - GC Ready", "Update Billing"};
       
		//WebDriverWait wait = new WebDriverWait(driver, 10);

	    for(String task:tasks1) {
		   System.out.println(task);
      
	       (new WebDriverWait(driver, 8)).until(new ExpectedCondition<WebElement>(){
	    		   @Override
	    		   public WebElement apply(WebDriver d) {
	    		   return d.findElement(By.linkText(task));
	    		   }});
	       
	       driver.findElement(By.linkText(task)).click();
		   Alert alert=driver.switchTo().alert();
		   alert.accept();
	    }
	    
	    driver.findElement(By.name("main:j_id92")).click();
	    Thread.sleep(2000);
		//Switching frames
		driver.switchTo().defaultContent();
	    driver.switchTo().frame("workspacePane");
	    System.out.println("Switched to Wokspacepane");
	    Thread.sleep(3000);	
	    driver.switchTo().frame("header_pane");
	    System.out.println("Switched to header_pane \n");
	    WebElement orderno= driver.findElement(By.xpath("//table[@id='cpi_table']//span[2]/descendant::a"));
	    WebElement lineItem=driver.findElement(By.xpath("//table[@id='cpi_table']/tbody/tr[2]/td[1]/span[3]"));
	    WebElement circuitID=driver.findElement(By.xpath("//table[@id='cpi_table']/tbody/tr[3]/td[1]/span[3]/a"));
	    WebElement Status=driver.findElement(By.xpath("//table[@id='cpi_table']/tbody/tr[1]/td[3]/span[2]"));
	    orderNo=orderno.getText();
	    LineItem=lineItem.getText();
	    status=Status.getText();
	    CircuitID=circuitID.getText();
	    System.out.println("Order number is: "+orderno.getText());
	    System.out.println("Line Item is: "+lineItem.getText());
	    System.out.println("############################# EON Automation #############################################");
	    System.out.println("Order/Item: " +orderno.getText()+lineItem.getText());
	    System.out.println("CircuitID: "+circuitID.getText());
	    System.out.println("Status: "+Status.getText());
	    System.out.println("############################# Scripted by Nanda Kumar #############################################");

	    driver.switchTo().defaultContent();
	   
	   //switch back to ITEMS Page
	   driver.switchTo().window(ItemTAB);
	   System.out.println(driver.getTitle());  
	   driver.switchTo().frame("navPane");
	   Thread.sleep(2000);
	   driver.findElement(By.id("navbar_refresh")).click();
	   Thread.sleep(2000);
	 //Takes screenshot and store as a file format 
	 File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("C://Users//ab54030//Desktop//NandaSelenium//SeleniumPractice//src//seleniumSession//EON.png"));

	}
	finally {
		driver.quit();
		driver=null;
	}
	
	}
	
	//To select the drop down using "select by visible text"
	public static void fn_Select(WebElement WE, String VisibleText){
	Select selObj=new Select(WE);
	selObj.selectByVisibleText(VisibleText);
	}
		
	//TO Select the auto listed text in drop down
		public static void fn_auotslectText(List<WebElement> autotextddl, String textToSelect) throws InterruptedException {	
			List<WebElement> list= autotextddl;
		    System.out.println("Total auto suggestions==>"+list.size());
		    for(int i=0; i<list.size(); i++){
		    	String autotexts=list.get(i).getText(); // to see the list of auto suggesting words
		    	System.out.println("The auto suggesting words are ==>"+autotexts);
	    		Thread.sleep(3000);

		    	if(autotexts.contains(textToSelect)){
		    		list.get(i).click(); // to click on any particular text in auto suggestion
		    		Thread.sleep(3000);
		    		break; // once it found the text comes out of the loop to save time as we found what we need to click
		    	}
		    }	
		}
	
		//to send email 
		@Test(dependsOnMethods="testpopup")
		public void sendEmail() {
		DateFormat dfobj = new SimpleDateFormat("MM/dd/yyyy");

		Date dateobj = new Date();

		System.out.println(dfobj.format(dateobj));

		System.out.println("Sending Order Details in email...");

		InetAddress ip;

		String hostname = null;

		String hostIPAddress = null;

		try {

			ip = InetAddress.getLocalHost();

			hostname = ip.getHostName();

			hostIPAddress =ip.getHostAddress();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		}

		java.util.Properties props = new java.util.Properties();

		props.put("mail.smtp.host", "mailgate.uswc.uswest.com");

		Session session = Session.getDefaultInstance(props, null);

		String from = "nnanda.kumar@centurylink.com";

		String subject = "EON Automation Sanity passed in QA4_" + dfobj.format(dateobj);
		//String subject = "This Mail is just for testing purpose to send email with screenshot where script gets failed_" + dfobj.format(dateobj);

		Message msg = new MimeMessage(session);

		try {       

			msg.setFrom(new InternetAddress(from));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Praveen_L3_Test@CenturyLink.com"));

			msg.setSubject(subject);

			MimeMultipart multipart = new MimeMultipart("related");

			BodyPart msgBodyPart = new MimeBodyPart();

			String htmlText = "<html>\n" +

	                        "<Head></head>\n"+

	                        "<body>\n"+

	                        "<pr>Hi All,</pr>\n"+

	                        "<br><br>\n"+

	                        "<pr>EON Automation Sanity passed in QA4 environment. Please find below order details,</pr>\n"+

							"<br>\n"+
							"<br>\n"+
	                        "<pr> Order/ Item: "+ orderNo +LineItem +"</p>\n"+

	                        "\n"+
	                        
	                        "<pr> CircuitID: "+CircuitID+ "</p>\n"+

	                        "\n"+
	                        
	                        "<pr> Status: "+status+ "</p>\n"+

	                        "<br>\n"+  
	                        
	                       // "<br><br>\n"+

                       // "<b><u>Validation Error Snapshot Details:</u></b>\n"+

	                       // "<br><br>\n"+

	                        "<table border= 2 cellpadding= 2 cellspacing= 0>\n"+

	                        "<tr><td colspan = 2>\n"+

	                        "<img  align =center src=\"cid:OrderDetails\" alt = Scripted By: Nanda Kumar(AB54030) title = Scripted By: Nanda Kumar(AB54030) border =2 bordercolor = #006600>\n"+

	                        "</td></tr>\n"+                                 

                            "<tr><b><td colspan = 2 align= left valign=middle style=background-color:#9ACD32;color:#000000;><font face= verdana size =1><center>Scripted By: Nanda Kumar(AB54030)</center></face></td></b></tr>\n"+

	                        "</table>\n"+

	                        "<br>\n"+
	                     
	                        "<pr>Host: System Name & IP Addresss on which Sanity script ran are\n"+ hostname +"<text>, </text>\n" + hostIPAddress+"</p>\n"+

	                        "<br>\n"+

	                      //  "<pr>****************************** Scripted by N Nanda Kumar(AB54030) ****************************</p>\n"+

	                      //  "<pr>***serenity-cucumber-archetype using Selenium 2, JUnit and Cucumber-JVM with CTL-STAF as dependency***</p>\n"+

	                        "<br>\n"+

//	                        "<pr>Note*: This sanity mail is a result of automatically triggered sanity build from corporate jenkins and a seperate cucumber-jvm report - configured in corporate jenkins goes to only few recipients. Screenshot doesnot display in case if application URL only is not launched </p>\n"+

	                        "<br>\n"+

	                        "<br>\n"+

	                        "<br>\n"+

							"<br>\n"+

	                        "<pr>Regards,</pr>\n"+

	                        "<br>\n"+

	                        "<pr>Nanda Kumar</pr>\n"+

	                        "</body>\n"+

	                        "</html>";                         

			msgBodyPart.setContent(htmlText, "text/html");
			multipart.addBodyPart(msgBodyPart);

			Map<String, String> mapinlineImages = new HashMap<String, String>();
			mapinlineImages.put("OrderDetails", "C:\\Users\\ab54030\\Desktop\\NandaSelenium\\SeleniumPractice\\src\\seleniumSession\\EON.png");

			if (mapinlineImages != null && mapinlineImages.size() > 0) {
				Set<String> setImageID = mapinlineImages.keySet();

				for (String contentId : setImageID) {
					MimeBodyPart imagePart = new MimeBodyPart();
					imagePart.setHeader("Content-ID", "<" + contentId + ">");
					imagePart.setDisposition(MimeBodyPart.INLINE);

					String imageFilePath = mapinlineImages.get(contentId);
					try {
						imagePart.attachFile(imageFilePath);
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					multipart.addBodyPart(imagePart);
				}
			}

			msg.setContent(multipart);
			Transport.send(msg);

			System.out.println("Sent email successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
