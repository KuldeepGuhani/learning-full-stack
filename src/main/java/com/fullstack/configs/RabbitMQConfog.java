package com.fullstack.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfog {

    public static final String Queue_Name = "order.queue";

    @Bean
    public Queue orderQueue(){
        return new Queue(Queue_Name, true);
    }

    @Bean
    public CommandLineRunner initRabbit(RabbitTemplate rabbitTemplate) {
        return args -> {
            rabbitTemplate.execute(channel -> null);
            System.out.println("RabbitMQ connected successfully!");
        };
    }

}
