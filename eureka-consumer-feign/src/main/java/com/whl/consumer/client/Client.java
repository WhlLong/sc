package com.whl.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client")
public interface Client {

    @GetMapping("/test")
    String test();

}
