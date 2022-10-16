package com.bridgelabz.greetingapp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingApp01Application {

    public static void main(String[] args) {

        SpringApplication.run(GreetingApp01Application.class, args);
        System.out.println("Application is running...");
    }

}
