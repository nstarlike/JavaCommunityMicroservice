package nstarlike.jcm.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import nstarlike.jcm.email.service.EmailService;

public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("test@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
	}

}
