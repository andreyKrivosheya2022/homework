CREATE TABLE products (
                          id BIGINT UNSIGNED AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          cost DECIMAL(10,2) NOT NULL,
                          PRIMARY KEY (id)
);

CREATE TABLE carts (
                       id BIGINT UNSIGNED AUTO_INCREMENT,
                       PRIMARY KEY (id)
);

CREATE TABLE carts_products (
                                cart_id BIGINT UNSIGNED NOT NULL,
                                product_id BIGINT UNSIGNED NOT NULL,
                                PRIMARY KEY (cart_id, product_id),
                                FOREIGN KEY (cart_id) REFERENCES carts (id) ON DELETE CASCADE,
                                FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);
