package com.journaldev.bootifulmongodb.controller;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.EmailOtpRepository;
import com.journaldev.bootifulmongodb.model.EmailOtp;
import com.journaldev.bootifulmongodb.model.User;



@RestController
@RequestMapping("/rest")
public class MailController {

 public String body;
//	
	@Autowired
    EmailOtpRepository emailOtpRespository;
	
	@RequestMapping(value = "/sendMail/{recipientsEmail}/{body}", method = RequestMethod.GET)
	public String sendEmail(@PathVariable("recipientsEmail") String recipientsEmail,@PathVariable("body") String body) {
		
			
			try {
				sendmail(recipientsEmail,body);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "Email sent successfully";
		
	}
	public void sendmail(String recipientsEmail,String body) throws AddressException, MessagingException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("cajrod28@gmail.com", "springmaster");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("cajrod28@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientsEmail));
		   msg.setSubject(body);   // Subject here
		   int code = (int)(Math.random() * 100000);
		   EmailOtp e = new EmailOtp();
		   e.setEmail(recipientsEmail); 
		   e.setOtp(Integer.toString(code));
		   this.emailOtpRespository.save(e);
		   msg.setContent("Your code is " + code , "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Your code is " + code, "text/html");
		   
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();

//		   attachPart.attachFile("/var/tmp/image19.png");
//		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
}
