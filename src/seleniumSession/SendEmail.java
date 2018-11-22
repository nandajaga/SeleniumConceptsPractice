package seleniumSession;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.testng.annotations.Test;

import javax.mail.Session;
import javax.mail.Transport;
 
 
public class SendEmail 
{
 
	@Test
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

	String subject = "EON Sanity passed in QA4_" + dfobj.format(dateobj);
	//String subject = "This Mail is just for testing purpose to send email with screenshot where script gets failed_" + dfobj.format(dateobj);

	Message msg = new MimeMessage(session);

	try {       

		msg.setFrom(new InternetAddress(from));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nnanda.kumar@centurylink.com"));

		msg.setSubject(subject);

		MimeMultipart multipart = new MimeMultipart("related");

		BodyPart msgBodyPart = new MimeBodyPart();

		String htmlText = "<html>\n" +

                        "<Head></head>\n"+

                        "<body>\n"+

                        "<pr>Hi All,</pr>\n"+

                        "<br><br>\n"+

                        "<pr>EON Sanity passed in QA4 environment. Please find below order details,</pr>\n"+

                        "<br><br>\n"+

                        "<b><u>Validation Error Snapshot Details:</u></b>\n"+

                        "<br><br>\n"+

                        "<table border= 2 cellpadding= 2 cellspacing= 0>\n"+

                        "<tr><td colspan = 2>\n"+

                        "<img  align =center src=\"cid:OrderDetails\" alt = Scripted By: Saurabh Kumar(SXKUM64) title = Scripted By: Saurabh Kumar(SXKUM64) border =2 bordercolor = #90ee90>\n"+

                        "</td></tr>\n"+                                 

                        "<tr><b><td colspan = 2 align= left valign=middle style=background-color:#9ACD32;color:#000000;><font face= verdana size =1><center>Scripted By: Saurabh Kumar (SXKUM64)</center></face></td></b></tr>\n"+

                        "</table>\n"+

                        "<br>\n"+

                        "<br>\n"+

                        "<br>\n"+

                        "<br>\n"+                                

                        "<pr>Host System Name & IP Addresss on which Sanity script ran are\n"+ hostname +"<text>, </text>\n" + hostIPAddress+"</p>\n"+

                        "<br>\n"+

                      //  "<pr>***serenity-cucumber-archetype using Selenium 2, JUnit and Cucumber-JVM with CTL-STAF as dependency***</p>\n"+

                        "<br>\n"+

//                        "<pr>Note*: This sanity mail is a result of automatically triggered sanity build from corporate jenkins and a seperate cucumber-jvm report - configured in corporate jenkins goes to only few recipients. Screenshot doesnot display in case if application URL only is not launched </p>\n"+

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