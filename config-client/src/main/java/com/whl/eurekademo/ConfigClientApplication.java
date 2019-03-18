package com.whl.eurekademo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

    @Value("${info.profile}")
    private String info;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }


    @GetMapping("/info")
    public String info(){
        return info;
    }


}
