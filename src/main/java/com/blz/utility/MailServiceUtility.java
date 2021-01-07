package com.blz.utility;



//package com.blz.utility;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//import com.blz.bookstore.dto.EmailObject;
//import com.blz.bookstore.exceptions.EmailSendingException;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//import javax.mail.Authenticator;
//
//@Component
//public class MailServiceUtility {
//
////	@Value("${spring.mail.username}")
////	private String SENDER_EMAIL_ID;
////	@Value("${spring.mail.password}")
////	private String SENDER_PASSWORD;
////
////	private boolean sendMail(String toEmailId, String subject, String bodyContaint) {
////		Authenticator authentication = new Authenticator() {
////
////			@Override
////			protected PasswordAuthentication getPasswordAuthentication() {
////				return new PasswordAuthentication(SENDER_EMAIL_ID, SENDER_PASSWORD);
////			}
////		};
////		Session session = Session.getInstance(mailPropertiesSettings(), authentication);
////		try {
////			Transport.send(mimeMessageConfiguration(session, toEmailId, subject, bodyContaint));
////			return true;
////		} catch ( MessagingException e) {
////			return false;
////		}
////	}
////
////	private MimeMessage mimeMessageConfiguration(Session session, String toEmail, String subject, String body) {
////
////		MimeMessage mimeMessage = new MimeMessage(session);
////		try {
////			mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
////			mimeMessage.addHeader("format", "flowed");
////			mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");
////			mimeMessage.setFrom(new InternetAddress(SENDER_EMAIL_ID, "OnlineBookStores"));
////			mimeMessage.setReplyTo(InternetAddress.parse(SENDER_EMAIL_ID, false));
////			mimeMessage.setSubject(subject, "UTF-8");
////			mimeMessage.setText(body, "UTF-8");
////			mimeMessage.setSentDate(new Date());
////			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
////		} catch (MessagingException | UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
////		return mimeMessage;
////	}
////
////	private Properties mailPropertiesSettings() {
////		Properties properties = new Properties();
////		properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
////		properties.put("mail.smtp.port", "587"); // TLS Port
////		properties.put("mail.smtp.auth", "true"); // enable authentication
////		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
////		properties.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
////		return properties;
////	}
////
////	@RabbitListener(queues = "rmq.rube.queue")
////	public void recievedMessage(EmailObject mailObject) {
////
//////		if (sendMail(mailObject.getEmail(), mailObject.getSubject(), mailObject.getMessage())) { 
//////			return;
//////		}
////		throw new EmailSendingException("Error in Sending mail!", HttpStatus.BAD_GATEWAY.value());
////	
////	}
//}