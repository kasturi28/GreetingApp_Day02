package com.bridgelabz.greetingapp01.service;

import com.bridgelabz.greetingapp01.entity.Greeting;
import com.bridgelabz.greetingapp01.entity.User;

public interface IGreetingService {
    String getGreetingMessage();
    String getGreetingMessage(User user);
    Greeting addGreetingMessage(User user);
}
