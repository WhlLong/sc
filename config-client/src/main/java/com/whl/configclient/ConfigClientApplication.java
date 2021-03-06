package com.whl.configclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@EnableDiscoveryClient
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
