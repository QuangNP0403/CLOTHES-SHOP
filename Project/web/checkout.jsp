<%-- 
    Document   : checkout.jsp
    Created on : Mar 2, 2024, 11:10:08 PM
    Author     : Quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bill</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Custom CSS -->
        <style>
            body {
                font-family: Arial, sans-serif;
                padding: 20px;
            }
            .bill-container {
                max-width: 800px;
                margin: 0 auto;
                border: 1px solid #ccc;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .bill-info {
                margin-top: 20px;
            }
            .bill-info h4 {
                margin-top: 0;
            }
            .bill-info p {
                margin-bottom: 5px;
            }
            .product {
                border-bottom: 1px solid #ccc;
                padding-bottom: 10px;
                margin-bottom: 20px;
            }
            .product-image {
                max-width: 100px;
                max-height: 100px;
                margin-right: 20px;
            }
        </style>
    </head>
    <body>
        <div class="bill-container">
            <h4 class="text-center mb-4">CHECKOUT</h4>
            <c:forEach items="${requestScope.vectorCO}" var="co">
                <div class="product">
                    <img src="${co.img}" alt="Product Image" class="product-image">
                    <div class="bill-info">
                        <h4>Product Name: ${co.product_name}</h4>
                        <c:if test="${co.status == 1}">
                            <p>Order Approval Status: Wait</p>
                        </c:if>
                        <c:if test="${co.status == 0}">
                            <p>Order Approval Status: Done</p>
                        </c:if>
                        <p>Product Price: $${co.price}</p>
                        <p>Shipping Address: ${co.address}</p>
                        <p>Phone Number: ${co.phone}</p>
                        <p>Date Order: ${co.order_date}</p>
                        <p>Product Quantity: ${co.quantity}</p>
                        <p>Total Price: $${co.total}</p>
                    </div>
                </div>
            </c:forEach>

            <!-- Add similar products here -->
            <div class="total-price">
                <h4 class="text-right">Total Price for All Products: $${requestScope.totalOrderValue}</h4>
            </div>
        </div>

        <!-- Bootstrap JS and jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
