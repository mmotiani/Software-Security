package com.group10.sparkysbank.service;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.group10.sparkysbank.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.group10.sparkysbank.service.EmailService#sendEmail(java.lang.String,
	 * java.lang.String)
	 */
	public void sendEmail(String key, String emailId) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"projectc18@gmail.com", "boyaguud");
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projectc18@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please! " + key);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean sendEmailWithAttachment(String emailId,String username,String decodedPwd, String token)
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"projectc18@gmail.com", "boyaguud");
					}
				});
		
		try {

			
			  MimeMessage message = new MimeMessage(session);

		         message.setFrom(new InternetAddress("projectc18@gmail.com"));
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(emailId));
		         message.setSubject("This is the Subject Line!");
		         BodyPart messageBodyPart = new MimeBodyPart();
		         messageBodyPart.setText("This is your token you will use for encryption\n"+token+"\nthe password for the pfx file is 123456"+"\n The Password for your new account is " + decodedPwd);
		         Multipart multipart = new MimeMultipart();

		         multipart.addBodyPart(messageBodyPart);

		         messageBodyPart = new MimeBodyPart();
		         String filename = username+".pfx";
		         DataSource source = new FileDataSource(filename);
		         messageBodyPart.setDataHandler(new DataHandler(source));
		         messageBodyPart.setFileName(filename);
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart );
		         
		         
		         Transport.send(message);
		         System.out.println("Sent message successfully....");
		        

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return false;

	}
	
	public String  generatePassword()
	{
		String chars = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

		final int PW_LENGTH = 6;
		Random rnd = new SecureRandom();
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < PW_LENGTH; i++)
			pass.append(chars.charAt(rnd.nextInt(chars.length())));
		
		return pass.toString();		
	}
}
	
	
