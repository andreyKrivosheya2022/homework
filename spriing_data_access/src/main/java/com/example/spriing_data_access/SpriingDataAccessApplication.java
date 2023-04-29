package com.example.spriing_data_access;

import com.example.spriing_data_access.config.AppConfig;
import com.example.spriing_data_access.dao.CartDao;
import com.example.spriing_data_access.dao.ProductDao;
import com.example.spriing_data_access.entity.Cart;
import com.example.spriing_data_access.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@Import(AppConfig.class)
public class SpriingDataAccessApplication implements CommandLineRunner {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(SpriingDataAccessApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Product product = new Product();
        Cart cart = new Cart();

        productDao.save(product);
        cartDao.save(cart);
        System.out.println(cart.getId());
        cartDao.addProductToCart(1L, 1L);
        cartDao.getById(cart.getId());
    }
}
