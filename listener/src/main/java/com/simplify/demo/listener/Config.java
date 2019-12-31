package com.simplify.demo.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.ApplicationArguments;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import java.util.Set;

@Configuration
public class Config {

    @Bean
    public Queue hello() {
        return new Queue("test");
    }

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
