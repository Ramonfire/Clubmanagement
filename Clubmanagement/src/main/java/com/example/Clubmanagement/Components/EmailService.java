package com.example.Clubmanagement.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

        @Autowired
        private JavaMailSender emailSender;

        public void sendSimpleMessage(
                String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("clubpageproject1@gmail.com");
            message.setTo(to);
            message.setSubject("MDP_UIR");
            message.setText(text);
            emailSender.send(message);
        }

}
