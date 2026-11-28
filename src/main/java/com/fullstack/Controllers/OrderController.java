package com.fullstack.Controllers;

import com.fullstack.Entities.Orders;
import com.fullstack.Services.OrderService;
import com.fullstack.rabbitmq.producer.OrderProducer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderProducer orderProducer;

    public  OrderController(OrderService orderService, OrderProducer orderProducer){
        this.orderService=orderService;
        this.orderProducer=orderProducer;
    }

    @PostMapping("/placeorder")
    public String placeOrder(@RequestBody String message){
        orderProducer.sendMessage(message);
        return "Order Places Sucess: "+message;
    }

    @PostMapping("/bulk/{count}")
    public String createBulkOrders(@PathVariable int count) {

        if (count < 1 || count > 10000) {
            throw new IllegalArgumentException("Invalid count");
        }

        for (int i = 1; i <= count; i++) {
            orderProducer.sendMessage("Order-" + i);
        }

        return count + " publish calls completed";
    }


    @GetMapping("/orders")
    public List<Orders> getOrders(){
        return orderService.getAll();
    }

    @PostMapping("/createOrders")
    public Orders createOrder(@RequestBody Orders order){
        return orderService.createOrder(order);
    }



}
