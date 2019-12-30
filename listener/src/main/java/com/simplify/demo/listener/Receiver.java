package com.simplify.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "test")
public class Receiver {

    private String i = "0";

    public Receiver(String i){
        this.i = i;
    }

    @RabbitHandler(isDefault = true)
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "' from instance" + i );
    }
}

