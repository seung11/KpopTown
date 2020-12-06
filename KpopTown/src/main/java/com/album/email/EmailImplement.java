package com.album.email;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailImplement implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public void SendEmail(Email email) throws Exception {
	
		System.out.println("���Ϻ�����");
		MimeMessage msg = mailSender.createMimeMessage();
		
		try {
			// ������
			msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email.getSenderMail()));
			// ����
			msg.setSubject(email.getSubject(), "utf-8");
			// ����
			msg.setText(email.getMessage(), "utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		try {
			mailSender.send(msg);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}

}
