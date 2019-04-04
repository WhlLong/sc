package com.whl.consumer;

import com.whl.consumer.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Client feignClient;

    @GetMapping("test")
    public String test(){
        return feignClient.test();
    }

}
