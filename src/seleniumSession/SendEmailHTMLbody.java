package seleniumSession;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendEmailHTMLbody {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//public void SendEmailhavingOrderDetails() {
		System.setProperty("webdriver.chrome.driver", "C://Users//ab54030//Desktop//NandaSelenium//chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
			Thread.sleep(10000);		
			
			driver.switchTo().frame("workspacePane");
			System.out.println("switched to workspace pane");
			driver.switchTo().frame("entry_pane");
			System.out.println("switched to entry pane");
			
			Point point = driver.findElement(By.xpath("html/body/form/table")).getLocation();
			int x = point.getX();
			int y = point.getY();
			int width = driver.findElement(By.xpath("html/body/form/table")).getSize().getWidth();
			int height = driver.findElement(By.xpath("html/body/form/table")).getSize().getHeight();		
			
			String usercwd = System.getProperty("user.dir");
	        System.out.println("Current User Working Directory Path: " + usercwd);
	        String EONCTLLogo = usercwd + "\\src\\test\\resources\\EON-GC-CenturyLinkLogo.jpg";
	        String EONGCOrderDetails = usercwd + "\\target\\EON-GC-OrderDetails.jpg";
	        String EONGCOrderDetailsCropped = usercwd + "\\target\\EON-GC-OrderDetails-Cropped.jpg";
			
			
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File(EONGCOrderDetails));
				Image orig = ImageIO.read(new File(EONGCOrderDetails));
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.OPAQUE);
				bi.getGraphics().drawImage(orig, 0, 0, width, height, x, y, x + width, y + height, null);
				ImageIO.write(bi, "jpg", new File(EONGCOrderDetailsCropped));
			}

			catch (IOException e)
			{
				System.out.println(e.getMessage());

			}
			
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

				hostIPAddress = ip.getHostAddress();

			} catch (UnknownHostException e) {

				e.printStackTrace();

			}

			java.util.Properties props = new java.util.Properties();

			props.put("mail.smtp.host", "mailgate.uswc.uswest.com");

			Session session = Session.getDefaultInstance(props, null);

			String from = "nnanda.kumar@centurylink.com";
			//String from = "saurabh.kumar@centurylink.com";

			String subject = "EON 2018-12-14 Dec SMR_Automation Sanity passed in QA4_" + dfobj.format(dateobj);

			Message msg = new MimeMessage(session);

			try {

				msg.setFrom(new InternetAddress(from));

				 //msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sxkum64@CenturyLink.com"));
				msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("EON_TEST@CenturyLink.com, Praveen_L3_Test@CenturyLink.com "));
				
				msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("vivek.jain@centurylink.com,keith.lamle@centurylink.com,Praveen.K.Chinni@centurylink.com,sheela.mamidi@centurylink.com,bhanup.pathipati@level3.com,rajesh.kollipara2@level3.com,lokesh.thakkalapatti@centurylink.com"));
				
				msg.setSubject(subject);

				MimeMultipart multipart = new MimeMultipart("related");

				BodyPart msgBodyPart = new MimeBodyPart();

				String productSelected = null;
				String Order_Item=null;
				String CircuitID=null;
				String actualStatus=null;
				String htmlText = "<html>\n" +	
				
	            				"<Head></head>\n"+

	                            "<body>\n"+

	                            "<pr>Hi All,</pr>\n"+

	                            "<br><br>\n"+

								"<pr>EON Automation Sanity passed in QA4 environment. Please find below order details,</pr>\n" +

	                            "<br><br>\n"+

	                            "<b><u>EON-GC Order Details:</u></b>\n"+

	                            "<br><br>\n"+

	                            "<table border= 2 cellpadding= 2 cellspacing= 0>\n"+

	                            "<tr><td colspan = 2>\n"+

	                            "<img  align =center src=\"cid:EON-GC-CenturyLinklogo\" alt = Scripted By: Saurabh Kumar(SXKUM64) title = Scripted By: Saurabh Kumar(SXKUM64) border =2 bordercolor = #006600>\n"+

	                            "</td></tr>\n"+                                 

	                            "<tr><td align= left valign=top style=background-color:#006600;color:#FFFFFF;>Product Name</td><td align= left valign=top style=background-color:#FFEBD6;color:#000000;>" + productSelected + "</td></tr>\n"+

	                            "<tr><td align= left valign=top style=background-color:#006600;color:#FFFFFF;>Order/Item</td><td align= left valign=top style=background-color:#FFEBD6;color:#000000;>" + Order_Item +"</td></tr>\n"+

	                            "<tr><td align= left valign=top style=background-color:#006600;color:#FFFFFF;>Circuit ID</td><td align= left valign=top style=background-color:#FFEBD6;color:#000000;>" + CircuitID + "</td></tr>\n"+

	                            "<tr><td align= left valign=top style=background-color:#006600;color:#FFFFFF;>Status</td><td align= left valign=top style=background-color:#FFEBD6;color:#000000;>"+ actualStatus +"</td></tr>\n"+

	                            //"<tr><td colspan = 2 align= left valign=middle style=background-color:#195C19;color:#FFFFFF;><font face= verdana size =1><center>Scripted By: EON_TEST (Nanda Kumar(AB54030) & Saurabh Kumar(SXKUM64))</center></face></td></tr>\n"+

	                            "</table>\n"+

	                            "<br>\n"+
	                            
								"<b><u>EON-GC Order's Snapshot Details:</u></b>\n" +

								"<br><br>\n" +
								
								"<table border= 2 cellpadding= 2 cellspacing= 0>\n" +

								"<tr><td colspan = 2>\n" +

	                            "<img  align =center src=\"cid:EON-GC-OrderDetails\" alt = Scripted By: Saurabh Kumar(SXKUM64) title = Scripted By: Saurabh Kumar(SXKUM64) border =2 bordercolor = #006600>\n"+

								"<tr><b><td colspan = 2 align= left valign=middle style=background-color:#195C19;color:#FFFFFF;><font face= verdana size =1><center>Scripted By:EON_TEST (Nanda Kumar(AB54030) & Saurabh Kumar(SXKUM64))</center></face></td></b></tr>\n"+

								"</table>\n" +                            
	                            
	                            "<br>\n"+

	                            "<br>\n"+                                

	                            "<pr>Host System Name & IP Addresss on which Sanity script ran are\n"+ hostname +"<text>, </text>\n" + hostIPAddress+"</p>\n"+

	                            "<br>\n"+
	                            
								"<pr>*** Implementation of CTL-STAF framework for EON-GC project is done by:<i><b>EON_Test (Nanda Kumar & Saurabh Kumar)</b></i> ***</p>\n"+
								"<pr>***<i><b>Chinni, Praveen K: PROJECT LEAD - TESTING; Jain, Vivek: Offshore, TECHNICAL MANAGER - TESTING; Lemle, Keith: Onshore, MGR IT TESTING</b></i> ***</p>\n"+
	                            
								"<br>\n"+

	                           // "<pr>Note*: This sanity mail is a result of automatically triggered sanity build from corporate jenkins and a seperate cucumber-jvm report - configured in corporate jenkins goes to only few recipients.</p>\n"+

	                            "<br>\n"+

	                            "<br>\n"+

	                            "<br>\n"+

								"<br>\n"+

	                            "<pr>Regards,</pr>\n"+

	                            "<br>\n"+

	                            "<pr>Saurabh Kumar</pr>\n"+

	                            "</body>\n"+

	                            "</html>";   


				msgBodyPart.setContent(htmlText, "text/html");
				multipart.addBodyPart(msgBodyPart);
				
				Map<String, String> mapinlineImages = new HashMap<String, String>();
				mapinlineImages.put("EON-GC-CenturyLinklogo", EONCTLLogo);
				mapinlineImages.put("EON-GC-OrderDetails", EONGCOrderDetails);
			 	     
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

				System.out.println("Sent message successfully....");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

			driver.switchTo().defaultContent();
			System.out.println("switched to default content");
		}



	

}
