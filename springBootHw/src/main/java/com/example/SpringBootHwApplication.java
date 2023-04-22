package com.example;

import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootHwApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHwApplication.class, args);
    }

    @Override
    public void run(String... args){

        Product product = new Product();
        Product product1 = new Product();
        Product product2 = new Product();

        List<Product> products = List.of(product, product1, product2);

        Order order = new Order();
        order.setDate(new Date(1980-12-01));
        order.setCost(new BigDecimal(10000));
        order.setProducts(products);

        orderRepository.save(order);
        orderRepository.save(order);
        orderRepository.save(order);
        orderRepository.save(order);

        System.out.println(orderRepository.findById(1L));
        System.out.println(orderRepository.findAll());
    }
}
