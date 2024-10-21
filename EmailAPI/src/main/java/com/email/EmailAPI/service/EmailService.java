package com.email.EmailAPI.service;

import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.util.Properties;


@Service
public class EmailService {

    public boolean sendAttach(String message, String subject, String to) {

        boolean f= false;
        String from = "saurabhindurkar5@gmail.com";
        //variable to gmail host
        String host = "smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();

        System.out.println("Properties -" + properties);

        //setting important information to properties objects
        //set host
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties,new Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("saurabhindurkar5@gmail.com", "myacc@123");
            }
                });

        try {
            session.setDebug(true);

            // Create a MimeMessage instance
            MimeMessage m = new MimeMessage(session);

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  //if want to send multi email, use []receipient type

//adding subject to message
            m.setSubject(subject);

//adding text to message
            m.setText(message);

//send
//step3:- send the message using transport class
            Transport.send(m);
            System.out.println("Send Successfully");
            f=true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return f;
        }
    }



