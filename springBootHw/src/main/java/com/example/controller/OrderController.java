package com.example.controller;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> showAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order showOrderById(@PathVariable long id) {
        return orderRepository.getReferenceById(id);
    }
}
