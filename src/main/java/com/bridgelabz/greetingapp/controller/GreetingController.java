package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private static final String template = "Hello, %s";
    private IGreetingService greetingService;

    private final AtomicLong counter= new AtomicLong();

    public GreetingController(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

//    @GetMapping("/greeting")
////    public String greeting(){
////        return greetingService.getGreetingMessage();
////    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "firstName", defaultValue = "Hello") String firstName,
                           @RequestParam(name = "lastName", defaultValue = "World") String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.getGreetingMessage(user);
    }

}