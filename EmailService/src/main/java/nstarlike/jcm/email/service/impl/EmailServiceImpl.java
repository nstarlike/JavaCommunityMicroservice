package nstarlike.jcm.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import nstarlike.jcm.email.service.EmailService;
import nstarlike.jcm.user.dto.UserEvent;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@KafkaListener(topics="${spring.kafka.topic.name}", groupId="${spring.kafka.consumer.groupId")
	@Override
	public void sendSimpleMessage(UserEvent userEvent) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("test@gmail.com");
			message.setTo(userEvent.getUser().getEmail());
			message.setSubject(userEvent.getStatus());
			message.setText(userEvent.getMessage());
			javaMailSender.send(message);
		}catch(Exception e) {
			System.out.println("############# failed to send an email");
		}
	}

}
