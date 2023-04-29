package com.example.spriing_data_access.dao;

import com.example.spriing_data_access.entity.Cart;
import com.example.spriing_data_access.entity.Product;
import com.example.spriing_data_access.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDao {
    private final String DELETE_QUERY = "delete from carts_products where cart_id = ? AND product_id = ?";
    private final String SAVE_QUERY = "INSERT INTO carts (id) VALUES (?)";
    private final String ADD_PRODUCT_QUERY = "insert into carts_products(cart_id, product_id) values (?, ?)";

    private final String FIND_BY_ID_QUERY = "select * from carts, carts_products" +
            " where carts.id = carts_products.cart_id AND carts.id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductMapper productMapper;

    public void save (Cart cart){
        jdbcTemplate.update(SAVE_QUERY, cart.getId());
    }

    public void addProductToCart(Long cartId, Long productId) {
        jdbcTemplate.update(ADD_PRODUCT_QUERY, cartId, productId);
    }

    public void deleteProductFromCart(Long cartId, Long productId) {
        jdbcTemplate.update(DELETE_QUERY, cartId, productId);
    }

    public Cart getById(Long id) {
        List<Product> products = jdbcTemplate.query(FIND_BY_ID_QUERY, productMapper, id);
        Cart cart = new Cart();
        cart.setProductsList(products);
        return cart;
    }
}
