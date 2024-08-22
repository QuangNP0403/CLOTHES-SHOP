<%-- 
    Document   : updateproduct
    Created on : Feb 19, 2024, 1:04:31 PM
    Author     : Đạt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 50%;
                margin: 20px auto;
                background-color: #fff;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                text-align: center;
            }

            h1 {
                color: #333;
                margin-bottom: 30px;
                font-size: 28px;
            }

            form {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            label {
                margin-bottom: 15px;
                color: #555;
                font-size: 18px;
                display: block;
            }

            input[type="text"], select {
                padding: 12px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                width: 100%;
                font-size: 16px;
            }

            button {
                padding: 15px 30px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
                font-size: 18px;
            }

            button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Update Product</h1>
            <c:set var="c" value="${requestScope.p}"/>
            <form action="update" method="post">
                <label for="productId">Product ID:</label>
                <input type="text" id="productId" name="productId" readonly value="${c.product_id}">

                <label for="categoryId">Category:</label>
                <select name="categoryId" id="categoryId">
                    <option value="1" ${c.category_id == 1 ? 'selected' : ''}>Đồ Nam</option>
                    <option value="2" ${c.category_id == 2 ? 'selected' : ''}>Đồ Nữ</option>
                    <option value="3" ${c.category_id == 3 ? 'selected' : ''}>Đồ Trẻ Em</option>
                </select>

                <label for="productName">Product Name:</label>
                <input type="text" id="productName" name="productName" value="${c.product_name}">

                <label for="image">Image:</label>
                <input type="text" id="image" name="image" value="${c.img}">

                <label for="description">Description:</label>
                <input type="text" id="description" name="description" value="${c.description}">

                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="${c.price}">

                <label for="quantityInStock">Quantity in Stock:</label>
                <input type="text" id="quantityInStock" name="quantityInStock" value="${c.stock_quantity}">

                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
