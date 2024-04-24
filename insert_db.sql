

INSERT INTO water_service (service_name) 
VALUES 
("nong thon"),
("thanh thi"),
("vung cao");
select * from water_service;

-- ---------------------------------------------------------

INSERT INTO pricing_rule (min_usage, max_usage, price, water_service_id) 
VALUES 
(10, 20, 2500, 1),
(20, 30, 3000, 1),
(10, 20, 3000, 2),
(20, 30, 4000, 2),
(10, 20, 1500, 3),
(20, 50, 2500, 3);
select * from pricing_rule;

-- ---------------------------------------------------------

INSERT INTO customer (name, address, email, phone, username, password, dob)
VALUES
('John Doe', '123 Main St, Anytown', 'johndoe@example.com', '555-1234', 'johndoe', 'password123', '1990-05-15'),
('Jane Smith', '456 Elm St, Anytown', 'janesmith@example.com', '555-5678', 'janesmith', 'password456', '1985-08-20'),
('Michael Johnson', '789 Oak St, Anytown', 'michaeljohnson@example.com', '555-9876', 'michaelj', 'password789', '1992-03-10'),
('Emily Brown', '321 Pine St, Anytown', 'emilybrown@example.com', '555-4321', 'emilyb', 'passwordabc', '1998-12-25'),
('David Lee', '654 Maple St, Anytown', 'davidlee@example.com', '555-8765', 'davidl', 'passwordxyz', '1980-11-03');
select * from customer;

-- ---------------------------------------------------------

INSERT INTO water_amount (amount, used_time, customer_id) 
VALUES 
(10, STR_TO_DATE('25-2-2020', '%d-%m-%Y'), 1),
(15, STR_TO_DATE('25-3-2020', '%d-%m-%Y'), 1),
(20, STR_TO_DATE('25-4-2020', '%d-%m-%Y'), 1),

(20, STR_TO_DATE('5-6-2024', '%d-%m-%Y'), 2),
(15, STR_TO_DATE('5-7-2024', '%d-%m-%Y'), 2),
(10, STR_TO_DATE('5-8-2024', '%d-%m-%Y'), 2),

(38, STR_TO_DATE('5-5-2023', '%d-%m-%Y'), 3),
(46, STR_TO_DATE('5-6-2023', '%d-%m-%Y'), 3),
(27, STR_TO_DATE('5-7-2023', '%d-%m-%Y'), 3),

(17, STR_TO_DATE('5-5-2024', '%d-%m-%Y'), 4),
(22, STR_TO_DATE('5-6-2024', '%d-%m-%Y'), 4),
(40, STR_TO_DATE('5-7-2024', '%d-%m-%Y'), 4),

(50, STR_TO_DATE('16-2-2022', '%d-%m-%Y'), 5),
(80, STR_TO_DATE('16-3-2022', '%d-%m-%Y'), 5),
(70, STR_TO_DATE('16-4-2022', '%d-%m-%Y'), 5);
select * from water_amount;

SELECT * FROM water_amount WHERE customer_id = 1 ORDER BY used_time DESC LIMIT 1;

-- ---------------------------------------------------------
INSERT INTO pricing_rule_water_amount (pricing_rule_id, water_amount_id) 
VALUES 
(1,  4),
(2,  1),
(3,  7),
(4,  8),
(3,  13),
(4,  15),
(5,  6),
(6,  2),
(6,  9),
(6,  14);
select * from pricing_rule_water_amount;


-- ---------------------------------------------------------

INSERT INTO employee (employee_role, username, password, name, address, email) 
VALUES 
("nhan_vien", "duchau@gmail.com", "123456", "Duc Hau", "BN", "duchau@gmail.com"),
("nhan_vien", "ngocminh@gmail.com", "123456", "Ngoc Minh", "BN", "duchau@gmail.com");
select * from employee;

-- ---------------------------------------------------------
INSERT INTO bill (payment, created_at, employee_id, customer_id, water_amount_id) 
VALUES 
("MOMO", STR_TO_DATE('25-2-2020', '%d-%m-%Y'), 1, 1, 3),
("CHUYEN KHOAN", STR_TO_DATE('25-3-2020', '%d-%m-%Y'), 2, 2, 6),
("TIEN MAT", STR_TO_DATE('25-4-2020', '%d-%m-%Y'), 1, 3, 9),
("TIEN MAT", STR_TO_DATE('5-6-2024', '%d-%m-%Y'), 2, 5, 15),
("MOMO", STR_TO_DATE('5-7-2024', '%d-%m-%Y'), 2, 1, 3),
("TIEN MAT", STR_TO_DATE('23-04-2022', '%d-%m-%Y'), 1, 5, 15),

("TIEN MAT", STR_TO_DATE('5-6-2023', '%d-%m-%Y'), 1, 1, 3),
("MOMO", STR_TO_DATE('5-7-2023', '%d-%m-%Y'), 1, 2, 6),
("TIEN MAT", STR_TO_DATE('5-5-2024', '%d-%m-%Y'), 2, 3, 9),
("CHUYEN KHOAN", STR_TO_DATE('16-3-2022', '%d-%m-%Y'), 1, 5, 15),
("TIEN MAT", STR_TO_DATE('16-4-2022', '%d-%m-%Y'), 2, 4, 12),

("CHUYEN KHOAN", STR_TO_DATE('5-5-2023', '%d-%m-%Y'), 2, 3, 9);

select * from bill;

-- ---------------------------------------------------------

-- SELECT MONTH(b.created_at) AS month, YEAR(b.created_at) AS year, SUM(pr.price) AS revenue
-- FROM Bill b
-- JOIN water_amount wa ON b.water_amount_id = wa.id
-- JOIN pricing_rule_water_amount prwa ON wa.id = prwa.water_amount_id
-- JOIN pricing_rule pr ON prwa.pricing_rule_id = pr.id
-- GROUP BY MONTH(b.created_at), YEAR(b.created_at)
-- ORDER BY YEAR(b.created_at), MONTH(b.created_at);



