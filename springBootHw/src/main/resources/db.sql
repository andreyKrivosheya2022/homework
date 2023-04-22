CREATE TABLE products
(
    id    int NOT NULL AUTO_INCREMENT,
    name  varchar(255),
    cost NUMERIC,
    orders_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (orders_id) REFERENCES orders (id)
);

CREATE TABLE orders
(
    id    int NOT NULL AUTO_INCREMENT,
    date timestamp,
    cost numeric,
    PRIMARY KEY (id)
);