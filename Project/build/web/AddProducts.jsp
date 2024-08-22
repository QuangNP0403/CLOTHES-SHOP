<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/addproduct.css">
    </head>
    <body>
        <h1>${requestScope.note}</h1>
        <form action="addproduct" method="post">
            <label for="productId">Enter Product ID:</label>
            <input type="text" id="productId" name="productId" required>
            <br/>

            <label for="categoryId">Enter Category:</label>
            <select name="categoryId" id="categoryId">
                <c:forEach items="${ListC}" var="c">
                    <option value="${c.category_id}">${c.category_name}</option>
                </c:forEach>
            </select>
            <br/>

            <label for="productName">Enter Product Name:</label>
            <input type="text" id="productName" name="productName" required>
            <br/>

            <label for="image">Enter Image URL:</label>
            <input type="text" id="image" name="image">
            <br/>

            <label for="description">Enter Description:</label>
            <input type="text" id="description" name="description">
            <br/>

            <label for="price">Enter Price:</label>
            <input type="text" id="price" name="price">
            <br/>

            <label for="quantityInStock">Enter Quantity in Stock:</label>
            <input type="text" id="quantityInStock" name="quantityInStock">
            <br/>

            <div class="button-container">
                <button type="submit" class="submit-btn">Submit</button>
                <a href="productcontroller" class="back-btn">Back</a>
            </div>
        </form>
    </body>
</html>
