package com.company;

import com.company.Cart.Cart;
import com.company.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import lombok.extern.slf4j.Slf4j;
import java.util.Scanner;

@Slf4j
public class ConsoleRunner {

    public void start() {
        log.info("/--------------------------------<Starting app>--------------------------------/");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Cart cart = context.getBean("cartBean", Cart.class);
        while (true) {
            showListOfCommands();
            String command = new Scanner(System.in).nextLine();
            switch (command) {
                case "1" -> {
                    int id = getId();
                    cart.addProduct(id);
                }
                case "2" -> {
                    int id = getId();
                    cart.deleteProduct(id);
                }
                case "3" -> cart.toString();
                case "4" -> log.info("Program was finished.");
                default -> log.warn("Wrong command entered. Please enter correct command!");
            }
            if (command.equals("4")) return;
        }
    }

    private static int getId() {
        System.out.println("Enter product`s id");
        return new Scanner(System.in).nextInt();
    }

    private void showListOfCommands() {
        System.out.println("""
                1 - To add product in cart enter
                2 - To delete product from cart enter
                3 - To print all products info enter
                4 - To finish program enter""");
    }
}
