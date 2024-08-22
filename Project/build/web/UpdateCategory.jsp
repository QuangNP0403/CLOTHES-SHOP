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
            <h1>Update Category</h1>
            <c:set var="c" value="${requestScope.c}"/>
            <form action="updatecatemanager" method="post">
                <label for="categoryID">Product ID:</label>
                <input type="text" id="categoryID" name="categoryID" readonly value="${c.category_id}">

                <label for="categoryName">Product Name:</label>
                <input type="text" id="categoryName" name="categoryName" value="${c.category_name}">
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
