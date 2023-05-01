

CREATE TABLE IF NOT EXISTS orders (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        order_date DATETIME,
                        order_cost DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS products (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          cost DECIMAL(10,2)
);

CREATE TABLE  IF NOT EXISTS orders_products (
                                 order_id BIGINT,
                                 product_id BIGINT,
                                 PRIMARY KEY (order_id, product_id),
                                 FOREIGN KEY (order_id) REFERENCES orders(id),
                                 FOREIGN KEY (product_id) REFERENCES products(id)
);

