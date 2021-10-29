package com.evan.hello.spring.cloud.alibaba.rocketmq.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    private MessageChannel output;

    // 引入自定义接口
    @Autowired
    private MySource source;

    public void send(String message) {
        output.send(MessageBuilder.withPayload(message).build());
    }

    public void sendOutput1(String message) {
        source.output1().send(MessageBuilder.withPayload(message).build());
    }

    public void sendOutput2(String message) {
        source.output2().send(MessageBuilder.withPayload(message).build());
    }
}
