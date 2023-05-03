package com.example.spring_web_servlet.repository;

import com.example.spring_web_servlet.model.Order;
import com.example.spring_web_servlet.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository{
    List<Order> listOfOrders;

    public OrderRepository(){
        this.listOfOrders = new ArrayList<>();
    }

    public void saveOrder(Order order){
        listOfOrders.add(order);
    }

    public Order getOrderById(int id){
        return listOfOrders.stream().filter(person ->
                person.getId()==id).findAny().orElse(null);
    }

    public List<Order> getAllOrders(){
        return listOfOrders;
    }


    @PostConstruct
    public void init() {
        Product bread = new Product(1L, "bread", new BigDecimal(50));
        Product water = new Product(2L, "water", new BigDecimal(20));
        Product cola = new Product(3L, "cola", new BigDecimal(30));

        List<Product> products = List.of(bread,water);
        List<Product> products1 = List.of(bread,cola);

        Order order1 = new Order(1L, LocalDateTime.now(), new BigDecimal(100), products);
        Order order2 = new Order(2L, LocalDateTime.now(), new BigDecimal(50), products1);

        listOfOrders.add(order1);
        listOfOrders.add(order2);
    }

}
