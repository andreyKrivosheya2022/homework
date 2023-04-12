package com.company.config;

import com.company.Cart.Cart;
import com.company.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public Cart cartBean() {
        return new Cart(productRepositoryBean());
    }

    @Bean
    public ProductRepository productRepositoryBean() {
        return new ProductRepository();
    }
}
