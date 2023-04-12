package com.company.repository;

import com.company.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ProductRepository {

    List<Product> storage;

    public ProductRepository() {
        this.storage = load();
    }

    public List<Product> load() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "beer", BigDecimal.valueOf(35)));
        products.add(new Product(2L, "cola", BigDecimal.valueOf(20)));
        products.add(new Product(3L, "joice", BigDecimal.valueOf(70)));
        return products;
    }

    public Product getById(long id){
        return storage.get(Math.toIntExact(id));
    }

    public List<Product> getAllStorage(){
        return storage;
    }

    public void removeProduct(Product product) {
        storage.remove(product);
        log.debug("Remove {} from product repository", product.getName());
    }

    public void addProduct(Product product) {
        storage.add(product);
        log.debug("Add {} in product repository", product.getName());
    }
}
