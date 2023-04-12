package com.company.Cart;

import com.company.entity.Product;
import com.company.repository.ProductRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
public class Cart {

    private final List<Product> selectedProducts;
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository){
        this.selectedProducts = new ArrayList<>();
        this.productRepository = productRepository;
    }

    public void addProduct(long id) {
        Product product = productRepository.getById(id);
        selectedProducts.add(product);
        productRepository.removeProduct(product);
        log.debug("Add {} in cart", product.getName());
    }

    public void deleteProduct(long id) {
        Product product = selectedProducts.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();
        selectedProducts.remove(product);
        productRepository.addProduct(product);
        log.debug("Delete {} from cart", product.getName());
    }
}