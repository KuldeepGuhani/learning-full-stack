package com.fullstack.rabbitmq.producer;

import com.fullstack.configs.RabbitMQConfog;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;


    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(RabbitMQConfog.Queue_Name,message);

        System.out.println("MQ Message Sent : " + message);
    }
}
