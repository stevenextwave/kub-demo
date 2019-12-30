package com.simplify.demo.listener;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeoutException;
import java.io.IOException;


@Configuration
public class Config {
    @Bean
    public Channel channel() throws IOException,TimeoutException   {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }

    @Bean
    public Send getSend(Channel channel) {
        return new Send(channel);
    }

}