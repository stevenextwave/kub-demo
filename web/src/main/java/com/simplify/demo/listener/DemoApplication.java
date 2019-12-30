package com.simplify.demo.listener;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.simplify.demo.listener.Send;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private Send sender;

    @RequestMapping("/")
    String send(@RequestParam("msg") String message) throws IOException {
		sender.deliver(message);
        return message;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}