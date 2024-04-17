package com.utlis.base;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class EmailSender {

    final static String senderEmail = ConfigReader.getProperty("email_sender");
    final static String senderPassword = ConfigReader.getProperty("password");

    public static void sendEmail(String recipientEmail, String subject, String htmlContent, String reportFilePath) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setContent(htmlContent, "text/html");

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Add attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(reportFilePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(reportFilePath);
            multipart.addBodyPart(messageBodyPart);

            // Set the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendEmailWithBody(String recipientEmail, String subject, String body, String reportFilePath) {
        
    	recipientEmail=ConfigReader.getProperty("mail_recivers");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);

            // Attach the reports
            String reportContent = new String(Files.readAllBytes(Paths.get(reportFilePath)));

            // Set email content as HTML
            message.setContent(reportContent, "text/html");

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    	
       
    }
}
