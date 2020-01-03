package com.simplify.demo.listener;

import com.rabbitmq.client.ConnectionFactory;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Receiver receiver(ApplicationArguments args) {
        return new Receiver(System.getenv("NAME"));
    }

    @Bean
     public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory() {
       ConnectionFactory factory = new ConnectionFactory();
       factory.setHost(System.getenv("HOST"));
       factory.setUsername(System.getenv("USERNAME"));
       factory.setPassword(System.getenv("PASSWORD"));

       SimpleRabbitListenerContainerFactory listenerfactory = new SimpleRabbitListenerContainerFactory();
       listenerfactory.setConnectionFactory(new CachingConnectionFactory(factory));
       return listenerfactory;
     }
}
