package com.fullstack.Services;

import com.fullstack.Entities.Orders;
import com.fullstack.repositories.OrderRepository;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> getAll() {
        return orderRepository.findAll();
    }
}
