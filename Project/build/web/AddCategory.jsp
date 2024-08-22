<%-- 
    Document   : AddCategory
    Created on : Mar 6, 2024, 9:19:50 PM
    Author     : Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
        <link rel="stylesheet" href="css/addcategory.css">
    </head>
    <body>
        <h1>${requestScope.note}</h1>
        <form action="addcate" method="POST">
            <label for="categoryID">Enter Category ID:</label>
            <input type="text" id="categoryID" name="categoryID" required>
            <br/>
            <label for="categoryName">Enter Product Name:</label>
            <input type="text" id="categoryName" name="categoryName" required>
            <br/>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
