package com.evan.hello.spring.cloud.alibaba.rocketmq.consumer.receive;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerReceive {
    @StreamListener("input")
    public void receiveInput(String message) {
        System.out.println("Receive input: " + message);
    }

    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

    @StreamListener("input3")
    public void receiveInput3(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

    @StreamListener("input4")
    public void receiveInput4(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }
}
