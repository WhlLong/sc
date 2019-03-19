package com.whl.eurekademo;

import com.whl.eurekademo.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private Client feignClient;

    @GetMapping("test")
    public String test(){
        return feignClient.test();
    }

}
