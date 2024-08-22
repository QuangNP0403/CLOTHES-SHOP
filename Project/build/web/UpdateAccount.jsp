<%-- 
    Document   : UpdateAccount
    Created on : Mar 18, 2024, 11:29:04 AM
    Author     : Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:set var="p" value="${requestScope.p}"/>
            <form action="updateaccount" method="post">
                <label for="txtUserid">User ID:</label>
                <input type="text" id="txtUserid" name="txtUserid" readonly value="${p.user_id}">

                <label for="txtUsername">Username</label>
                <input type="text" id="txtUsername" name="txtUsername" value="${p.username}">

                <label for="txtPassword">Product Name:</label>
                <input type="text" id="txtPassword" name="txtPassword" value="${p.password}">

                <label for="txtAddress">Description:</label>
                <input type="text" id="txtAddress" name="txtAddress" value="${p.address}">

                <label for="txtPhone">Price:</label>
                <input type="text" id="txtPhone" name="txtPhone" value="${p.phone}">

                <label for="txtUser">Quantity in Stock:</label>
                <input type="text" id="txtUser" name="txtUser" value="${p.isUser}">

                <label for="txtAdmin">Quantity in Stock:</label>
                <input type="text" id="txtAdmin" name="txtAdmin" value="${p.isAdmin}">

                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
