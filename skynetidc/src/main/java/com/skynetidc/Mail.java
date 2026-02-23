package com.skynetidc;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Mail {

	public static void main(String[] args) {
		// Recipient's email ID needs to be mentioned.
		String to = "hoa9x3@gmail.com";// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "sales@skynetidc.vn";// change accordingly

		final String username = "sales@skynetidc.vn";// change accordingly
		final String password = "?B!Sz93*yH";// change accordingly

		// Zoho's SMTP server
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.zoho.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.zoho.com");

		// Get the Session object.
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			System.out.println("Indisde rty");
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Zoho - Email Test");

			// Now set the actual message
			message.setText("Hello, this is sample email to check/send " + "email using JavaMailAPI from Zoho");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully.... from Zoho");

		}
		catch (MessagingException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
