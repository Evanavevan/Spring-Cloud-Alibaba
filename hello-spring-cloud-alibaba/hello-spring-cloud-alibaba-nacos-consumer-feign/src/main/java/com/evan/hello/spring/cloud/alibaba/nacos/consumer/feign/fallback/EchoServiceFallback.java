package com.evan.hello.spring.cloud.alibaba.nacos.consumer.feign.fallback;

import com.evan.hello.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {
    public String echo(String message) {
        return "echo fallback";
    }
}
