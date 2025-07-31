package com.example.demo.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public String sendSimpleMail(String email, String text, String subject) {

		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo(email);
			mailMessage.setText(text);
			mailMessage.setSubject(subject);

			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

}
