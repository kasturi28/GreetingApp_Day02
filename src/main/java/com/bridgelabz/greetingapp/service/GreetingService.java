package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public String getGreetingMessage(){
        return "Hello World!";
    }

    @Override
    public String getGreetingMessage(User user) {
        String name = user.toString().isEmpty() ? "Hello world " : user.toString();
        return String.format(template,name);
    }
}
