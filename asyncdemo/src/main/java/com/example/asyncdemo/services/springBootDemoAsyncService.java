package com.example.asyncdemo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class springBootDemoAsyncService {

    @Async
    public void processTask(String payload){
        log.info("Starting Thread - Processing Thread {}", payload);
        log.info("Length of payload string is {}", payload.length());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Existing Thread - Processing Thread {}", payload);

    }
}
