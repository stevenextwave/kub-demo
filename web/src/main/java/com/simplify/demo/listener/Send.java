package com.simplify.demo.listener;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import com.rabbitmq.client.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class Send {
  
    private Channel channel;

    @Autowired
    public Send(Channel channel){
        this.channel = channel;
    }

    public void deliver(String message) throws IOException{
        System.out.println("Sending message " + message);
        channel.basicPublish("", "test",
            MessageProperties.PERSISTENT_TEXT_PLAIN,
            message.getBytes());
    }

    

}
