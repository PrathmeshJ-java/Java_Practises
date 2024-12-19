package com.example.asyncdemo;

import com.example.asyncdemo.services.springBootDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringBootDemAsyncRunner implements CommandLineRunner {

    @Autowired
    springBootDemoService springBooDemoService;

    @Override
    public void run(String... args) throws Exception {

        springBooDemoService.processTask();

    }
}
