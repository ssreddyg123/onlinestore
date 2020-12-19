INSERT INTO USERS(username,password,birthday) VALUES ('user1', 'user@199',TO_DATE('01-12-1981','dd-MM-yyyy'));  
INSERT INTO USERS(username,password,birthday) VALUES ('user2', 'user@299',TO_DATE('01-08-1985','dd-MM-yyyy'));  
INSERT INTO USERS(username,password,birthday) VALUES ('user3', 'user@399',TO_DATE('01-06-1982','dd-MM-yyyy'));

INSERT INTO BEVERAGES(type) VALUES ('Water');
INSERT INTO BEVERAGES(type) VALUES ('Soft drinks');
INSERT INTO BEVERAGES(type) VALUES ('Spirits');
INSERT INTO BEVERAGES(type) VALUES ('Cider');
INSERT INTO BEVERAGES(type) VALUES ('Energy Drinks');
INSERT INTO BEVERAGES(type) VALUES ('Wine');

INSERT INTO BOTTLES(name,bottle_pic, volume,is_alcoholic,volume_percent,price,supplier,in_stock,beverage_id) 
VALUES ('water', 'https://unsplash.com/photos/CdZcOCBUP98',20.0,true,25.2,250,'TATA',500,1);
INSERT INTO BOTTLES(name,bottle_pic, volume,is_alcoholic,volume_percent,price,supplier,in_stock,beverage_id) 
VALUES ('MineralWater', 'https://unsplash.com/photos/CdZgcvf456',30.0,true,27.2,255,'Kinley',800,1);
INSERT INTO BOTTLES(name,bottle_pic, volume,is_alcoholic,volume_percent,price,supplier,in_stock,beverage_id) 
VALUES ('CoolDrink', 'https://unsplash.com/photos/CdZcOCB254',40.0,true,25.2,550,'Coca-Cola',700,1);
INSERT INTO BOTTLES(name,bottle_pic, volume,is_alcoholic,volume_percent,price,supplier,in_stock,beverage_id) 
VALUES ('SoftDrink', 'https://unsplash.com/photos/CdZcOCB74P98',70.0,true,55.2,450,'RedPort',850,2);
INSERT INTO BOTTLES(name,bottle_pic, volume,is_alcoholic,volume_percent,price,supplier,in_stock,beverage_id) 
VALUES ('Drink', 'https://unsplash.com/photos/CdZcOCBUP98',50.0,true,75.2,250,'KingFisher',800,2);
INSERT INTO BOTTLES(name,bottle_pic, volume,is_alcoholic,volume_percent,price,supplier,in_stock,beverage_id) 
VALUES ('Coffee', 'https://unsplash.com/photos/CdZcOCBUP98',15.0,true,23.2,355,'Nescafe',700,3);

INSERT INTO CRATES(name,crate_pic, no_of_bottles,price,in_stock,beverage_id) 
VALUES ('Wood box','https://unsplash.com/photos/S7VRvq6sCvA',20,250,500,1);
INSERT INTO CRATES(name,crate_pic, no_of_bottles,price,in_stock,beverage_id) 
VALUES ('box','https://unsplash.com/photos/S7VRvq6sCvA',30,50,600,2);
INSERT INTO CRATES(name,crate_pic, no_of_bottles,price,in_stock,beverage_id) 
VALUES ('FloraJar','https://unsplash.com/photos/S7VRvq6sCvA',30,45,650,3);


INSERT INTO ORDERS(price,user_name) VALUES (300.50,'user1');
INSERT INTO ORDERS(price,user_name) VALUES (500.50,'user1');
INSERT INTO ORDERS(price,user_name) VALUES (700.50,'user1');
INSERT INTO ORDERS(price,user_name) VALUES (350.50,'user1');
INSERT INTO ORDERS(price,user_name) VALUES (520.50,'user1');
INSERT INTO ORDERS(price,user_name) VALUES (710.50,'user1');
INSERT INTO ORDERS(price,user_name) VALUES (800.50,'user2');
INSERT INTO ORDERS(price,user_name) VALUES (650.50,'user3');
INSERT INTO ORDERS(price,user_name) VALUES (651.50,'user3');
INSERT INTO ORDERS(price,user_name) VALUES (652.50,'user3');

INSERT INTO ORDERITEMS(position,price,order_id) VALUES (1, 70.50, 1);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (2, 50.50,1);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (3, 60.50,1);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (4, 65.50,1);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (4, 65.50,1);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (4, 65.50,2);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (4, 65.50,2);
INSERT INTO ORDERITEMS(position,price,order_id) VALUES (4, 65.50,2);