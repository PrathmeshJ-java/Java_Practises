package com.example.asyncdemo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class springBootDemoService {

    @Autowired
    springBootDemoAsyncService asyncService;

    public void processTask(){
        log.info("Starting the task list");
        List<String> TaskList = new ArrayList<>();
        TaskList.add("banana");
        TaskList.add("Mango");
        TaskList.add("Apple");
        TaskList.add("Watermetion");
        TaskList.add("papaya");
        TaskList.add("gavava");
        TaskList.add("chikoo");
        TaskList.add("cucumber");
        TaskList.add("carrot");
        TaskList.add("ginger");
        TaskList.add("pinaple");
        TaskList.add("Orange");
        TaskList.add("lemon");
        TaskList.add("sugercane");

        log.info("start processing the task list");

        for(String payload: TaskList){
           asyncService.processTask(payload);
        }

       log.info("completed the processing tasklist");

    }
}
