INSERT INTO product(id, name, price) VALUES(1, 'Product 1', 99.98);
INSERT INTO product(id, name, price) VALUES(2, 'Product 2', 99.87);

INSERT INTO customer_order(id, order_date, customer_id, customer_email) VALUES(1, {ts '2018-12-01T18:47:52.692'}, 2001, 'customer_em@text.com');
INSERT INTO customer_order(id, order_date, customer_id, customer_email) VALUES(2, {ts '2018-12-02T14:30:50.672'}, 2002, 'customer_em1@text76.com');


INSERT INTO order_line(id, order_id, product_id, title, price, quantity) VALUES(1, 1, 1 ,'Product 1', 99.98, 2);
INSERT INTO order_line(id, order_id, product_id, title, price, quantity) VALUES(2, 2, 2 ,'Product 2', 99.87, 2);