package com.blz.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(String to, String subject, String body, String token) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		helper = new MimeMessageHelper(message, true);
		String msgBody = "Hi, " + "\n" + "Use below link to reset your password: " + "\n" + body + "\n";
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(msgBody);
		javaMailSender.send(message);
	}
}
