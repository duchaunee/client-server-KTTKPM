create database water_service;
use water_service;

-- 1
CREATE TABLE water_service (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    service_name varchar(255)
);

-- 2
CREATE TABLE pricing_rule (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    min_usage Integer,	
    max_usage Integer,	
    price Double,
    
    water_service_id Integer,
    FOREIGN KEY (water_service_id) REFERENCES water_service(id)
);

-- 3
CREATE TABLE customer (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    address varchar(255),
    email varchar(255),
    phone varchar(255),
    username varchar(255),
    password varchar(255),
    dob Date
);

-- 4
CREATE TABLE water_amount (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    amount Integer,	
    used_time Date,
    
    customer_id Integer,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- 5
CREATE TABLE pricing_rule_water_amount (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    
    pricing_rule_id Integer,
    water_amount_id Integer,
    
    FOREIGN KEY (pricing_rule_id) REFERENCES pricing_rule(id),
    FOREIGN KEY (water_amount_id) REFERENCES water_amount(id)
);

-- 6
CREATE TABLE employee (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    employee_role varchar(255),
    username varchar(255),
    password varchar(255),
    name varchar(255),
    address varchar(255),
    email varchar(255)
);

-- 7
CREATE TABLE Bill (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    payment varchar(255),
    created_at Date,
    
    employee_id Integer,
    customer_id Integer,
    water_amount_id Integer,
    
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (water_amount_id) REFERENCES water_amount(id)
);

