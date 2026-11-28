package com.fullstack.rabbitmq.consumer;

import com.fullstack.configs.RabbitMQConfog;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

   @RabbitListener(queues = RabbitMQConfog.Queue_Name)
    public void receiveMessage(String message)
            throws InterruptedException {

        System.out.println("Received: " + message);

        Thread.sleep(30000);

        System.out.println("Processed: " + message);
    }
}
