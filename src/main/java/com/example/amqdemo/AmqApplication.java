package com.example.amqdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJms
public class AmqApplication {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AmqApplication.class, args);
    }

    // Method to send a message to the queue
    @PostConstruct
    public void sendMessage() {
        String message = "Helo World!";
        jmsTemplate.convertAndSend("queueName", message);
        System.out.println("Sent message: " + message);
    }

    // Method to receive messages from the queue
    @JmsListener(destination = "queueName")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
