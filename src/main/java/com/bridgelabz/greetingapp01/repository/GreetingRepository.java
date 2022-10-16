package com.bridgelabz.greetingapp01.repository;

import com.bridgelabz.greetingapp01.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository  extends JpaRepository<Greeting, Long> {

}
