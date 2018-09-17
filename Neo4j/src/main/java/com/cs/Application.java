package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication(scanBasePackages = "com.cs")
public class Application {
    @RequestMapping(value = "/")
    String index(){
        return "main/index";
    }
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
