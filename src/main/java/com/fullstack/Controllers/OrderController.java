package com.fullstack.Controllers;

import com.fullstack.Entities.Orders;
import com.fullstack.Services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;

    public  OrderController(OrderService orderService){
        this.orderService=orderService;
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
