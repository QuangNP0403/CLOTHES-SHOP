--create database Project_PRJ

CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    category_name NVARCHAR(255)
);

CREATE TABLE UserAccounts (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
	address varchar(255),
	phone int,
	isUser int DEFAULT 1,  -- user
    isAdmin int DEFAULT 0 -- admin
);

CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name NVARCHAR(255),
	img VARCHAR(255),
    description NVARCHAR(500),
    price DECIMAL(10, 2),
    stock_quantity INT,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY IDENTITY (1,1),
    user_id INT,
    order_date DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES UserAccounts(user_id)
);

CREATE TABLE OrderDetails (
    order_id INT,
	product_id INT,
	quantity INT,
    unit_price DECIMAL(10,2),
	Total DECIMAL(10,2),
    [status] INT,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

INSERT INTO Categories (category_id, category_name) VALUES 
(1, N'Đồ Nam'), 
(2, N'Đồ Nữ'), 
(3, N'Đồ Trẻ Em');


INSERT INTO Products (product_id, product_name, description, price, stock_quantity, category_id, img) VALUES 
(1, N'Áo sơ mi dài tay Insidemen ILS05103', N'Áo thiết kế đơn giản, tà lượn không túi, màu sắc trendy với hiệu ứng dobby mang đến sự trẻ trung, cá tính cho người mặc', 300.00, 20, 1, 'https://product.hstatic.net/200000605631/product/img_5724.1-1_a6793b4c627245b7b465cad77b70ab50_master.png'),
(2, N'Áo sơ mi dài tay Insidemen ILS05303', N'Áo thiết kế đơn giản, tà lượn không túi, màu sắc trendy với hiệu ứng dobby mang đến sự trẻ trung, cá tính cho người mặc', 310.00, 15, 1, 'https://product.hstatic.net/200000605631/product/img_5737_7fccd9a82e6a4cb8b539a61fafb8c0ff_master.png'),
(3, N'Áo sơ mi dài tay Insidemen ILS05503', N'Áo thiết kế đơn giản có túi ngực màu sắc trung tính dễ dàng kết hợp với nhiều loại trang phục, nhiều phong cách khác nhau', 320.00, 30, 1, 'https://product.hstatic.net/200000605631/product/img_5749.1_8072c3e9d6294b74a9c9a871d58f52a5_master.jpg'),
(4, N'Áo sơ mi dài tay Insidemen ILS06503', N'Áo thiết kế đơn giản, tà lượn có túi hộp, màu sắc trung tính mang đến sự trẻ trung, cá tính cho người mặc', 330.00, 25, 1, 'https://product.hstatic.net/200000605631/product/img_5718.1_c064dcd9d7c641f5a11637564097ec4d_master.jpg'),
(5, N'Áo sơ mi dài tay Insidemen ILS0710Z', N'Thiết kế tà lượn có túi, cùng màu trắng thanh lịch với điểm nhấn là hình in trên túi ngực cá tính, logo thêu ở gấu tay áo.', 340.00, 20, 1, 'https://product.hstatic.net/200000605631/product/img_2089.1_b8b0bcf30dfc42f1b74426a1164db216_master.jpg'),
(6, N'Áo sơ mi khoác Insidemen IAK002W3', N'Áo thiết kế đơn giản với 2 túi hộp ở mặt trước, màu sắc trẻ trung kết hợp cùng họa tiết kẻ đem đến diện mạo năng động, cá tính cho người mặc', 350.00, 18, 1, 'https://product.hstatic.net/200000605631/product/img_4960.1_62e178c326b748428535667362880872_master.jpg'),
(7, N'Áo sơ mi khoác Insidemen IAK005W3', N'Áo thiết kế đơn giản với 2 túi hộp ở mặt trước, màu sắc trẻ trung đem đến diện mạo năng động, cá tính cho người mặc', 360.00, 22, 1, 'https://product.hstatic.net/200000605631/product/img_0382.1_ac338ea14121433899746a46b90d3d54_master.jpg'),
(8, N'Áo sơ mi khoác Insidemen IAK006W3 ', N'Áo thiết kế đơn giản với 2 túi hộp ở mặt trước, màu sắc trẻ trung đem đến diện mạo năng động, cá tính cho người mặc', 370.00, 26, 1, 'https://product.hstatic.net/200000605631/product/img_0396.1_15086336fd954627815a4c92fccf08d5_master.jpg'),
(9, N'Áo sơ mi khoác Insidemen IAK007W3', N'Áo thiết kế đơn giản với 2 túi hộp ở mặt trước, màu sắc đen kẻ dobby mang đến sự trẻ trung, cá tính cho người mặc', 380.00, 24, 1, 'https://product.hstatic.net/200000605631/product/img_8987.1_2d8956cec44c4d0f8579363fc93ce3b7_master.jpg');

INSERT INTO Products (product_id, product_name, description, price, stock_quantity, category_id, img) VALUES 
(10, N'Áo Cổ Thường Vải Dầu Tay Dài Nữ', N'Sản phẩm được làm từ vải cây gai dầu, ít gây tác động tới môi trường', 420.00, 30, 2, 'https://img.muji.net/img/item/4550512687627_06_1260.jpg'),
(11, N'Áo Kiểu Vải Rayon In Họa Tiết Dài Tay', N'Cảm giác mềm mại và mịn màng. Chống nhăn để dễ chăm sóc sau khi giặt.', 470.00, 26, 2, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/463486/item/goods_01_463486.jpg?width=750'),
(12, N'Áo Kiểu Vải Rayon Ngắn Tay', N'Cảm giác mềm mại và mịn màng. Chống nhăn để dễ dàng chăm sóc sau khi giặt.', 430.00, 25, 2, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/464721/sub/goods_464721_sub14.jpg?width=750'),
(13, N'Áo Sơ Mi Cotton Washed Cổ Thường Nữ', N'Sản phẩm tạo cảm giác êm ái bằng cách sử dụng sợi bông mịn bền và tinh tế;', 410.00, 15, 2, 'https://img.muji.net/img/item/4550512686415_06_1260.jpg'),
(14, N'Áo Sơ Mi Nữ Dài Tay Cổ Trụ Vải Flannel Nữ', N'Sản phẩm tạo cảm giác ấm áp và mềm mại khi mặc, sử dụng chất liệu bông hữu cơ', 400.00, 20, 2, 'https://img.muji.net/img/item/4550512169918_07_1260.jpg'),
(15, N'Áo Sơ Mi Vải Linen Kẻ Sọc Dài Tay', N'100% vải lanh cao cấp tạo ra màu sắc tuyệt đẹp. Có thể mặc riêng hoặc khoác ngoaì.', 450.00, 18, 2, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/458283/item/goods_73_458283.jpg?width=750'),
(16, N'Áo Sơ Mi Vải Linen Pha Cổ Mở Ngắn Tay', N'Thiết kế linh hoạt cho bạn một cảm giác tự nhiên.', 480.00, 24, 2, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/464739/sub/goods_464739_sub14.jpg?width=750'),
(17, N'Áo Vải Linen Cao Cấp Dài Tay', N'Thiết kế đa năng này có thể mặc riêng hoặc như một lớp khoác nhẹ bên ngoài.', 460.00, 22, 2, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/455749/item/goods_67_455749.jpg?width=750'),
(18, N'Áo Vải Rayon Dài Tay', N'Vải Rayon mịn với độ bóng tuyệt đẹp. Chống nhăn để chăm sóc dễ dàng.', 440.00, 20, 2, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/433604/item/goods_09_433604.jpg?width=750');

INSERT INTO Products (product_id, product_name, description, price, stock_quantity, category_id, img) VALUES 
(19, N'Sơ mi tay ngắn màu cà tím', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 100.00, 30, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-T.jpg'),
(20, N'Sơ mi tay ngắn sọc nhí đỏ', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 110.00, 35, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-S.jpg'),
(21, N'Sơ mi màu hồng tay ngắn ', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 120.00, 40, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-H.jpg'),
(22, N'Sơ mi tay ngắn màu xanh trời', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 130.00, 25, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-9.jpg'),
(23, N'Sơ mi tay ngắn màu xanh ngọc', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 140.00, 20, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-8.jpg'),
(24, N'Sơ mi tay ngắn xọc xám', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 150.00, 32, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-7.jpg'),
(25, N'Sơ mi bé trai màu trắng đỏ gạch', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 160.00, 28, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-6.jpg'),
(26, N'Sơ mi tay ngắn màu vàng ', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 170.00, 36, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM123-1.jpg'),
(27, N'Sơ mi tay ngắn màu trắng ', N'Chất vải linen cotton, mỏng vừa, mềm mại, mát tay, thấm hút mồ hôi.', 180.00, 24, 3, 'https://www.besanhdieu.com/images/stories/virtuemart/product/SM133-5.jpg');

INSERT INTO UserAccounts (username, password, [address], phone, isUser, isAdmin)
VALUES ('Adam', '123', '123 Main Street, Cityville', 1234567890, 1, 0);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Anjolie', '123', '456 Elm Street, Townsville', 1234567891, 1, 0);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Ferris', '123', '789 Oak Avenue, Villageton', 1234567892, 1, 0);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Katell', '123', '321 Pine Road, Hamletville', 1234567893, 1, 0);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Zahir', '123', '987 Maple Lane, Boroughburg', 1234567894, 0, 1);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Conan', '123', '654 Cedar Street, Township', 1234567895, 0, 1);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Cade', '123', '321 Birch Avenue, Hamletville', 1234567896, 0, 1);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Micah', '123', '159 Spruce Road, Settlement', 1234567897, 0, 0);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Rowan', '123', '753 Pine Lane, Hamletville', 1234567898, 0, 0);

INSERT INTO UserAccounts (username, password, address, phone, isUser, isAdmin)
VALUES ('Tanisha', '123', '852 Oak Street, Boroughburg', 1234567899, 0, 0);
