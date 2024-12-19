package com.psj.springDockerExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker")
public class myController {

    @GetMapping("/home")
    public String home(){
        return "welcome in docker demo application";
    }
}
