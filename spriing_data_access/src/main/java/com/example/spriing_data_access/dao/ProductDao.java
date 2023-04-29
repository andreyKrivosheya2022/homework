package com.example.spriing_data_access.dao;

import com.example.spriing_data_access.entity.Product;
import com.example.spriing_data_access.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductMapper productMapper;

    private String DELETE_QUERY = "DELETE FROM products WHERE id = ?";
    private String SAVE_QUERY = "INSERT INTO products (name, cost) VALUES (?,?)";
    public void delete (Long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }
    public void save (Product product){
        jdbcTemplate.update(SAVE_QUERY, product.getName(), product.getCost());
    }

    public Product findById(Long id) {
        return (Product) jdbcTemplate.query(
                "SELECT * FROM products WHERE id = ?",
                new Object[]{id},
                productMapper
        );
    }

    public List<Product> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM products",
               productMapper
        );
    }
}
