package com.bridgelabz.greetingapp01.service;

import com.bridgelabz.greetingapp01.entity.Greeting;
import com.bridgelabz.greetingapp01.entity.User;
import com.bridgelabz.greetingapp01.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    @Autowired
    private GreetingRepository greetingRepository;

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

    @Override
    public Greeting addGreetingMessage(User user) {
        String name = user.toString().isEmpty() ? "Hello world " : user.toString();
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),String.format(template,name)));
    }

    @Override
    public Greeting getGreetingMsgById(long id) {
        Optional<Greeting> msg = greetingRepository.findById(id);
        return msg.get();
    }

    @Override
    public List<Greeting> getAllGreetingMsg(){
        return greetingRepository.findAll();
    }
}

