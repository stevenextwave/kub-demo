package com.simplify.demo.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.ApplicationArguments;
import java.util.Set;

@Configuration
public class Config {

    @Bean
    public Queue hello() {
        return new Queue("test");
    }

    @Bean
    public Receiver receiver(ApplicationArguments args) {
        /*String[] arg = args.getSourceArgs();
        for (String a : arg) {
            System.out.println(a);   
        }
        Set<String> argn = args.getOptionNames();
        for (String a : argn) {
            System.out.println(a);   
        }*/
       // System.out.println(args.getOptionValues("name").get(0));   
        //return new Receiver(args.getOptionValues("name").get(0));
        return new Receiver("1");
    }
}