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
        <form action="addaccount" method="post">
            
            <label for="txtUserid">Enter User ID:</label>
            <input type="text" id="txtUserid" name="txtUserid" required>
            <br/>

            <label for="txtUsername">Enter Username:</label>
            <input type="text" id="txtUsername" name="txtUsername" required>
            <br/>

            <label for="txtPassword">Enter Password:</label>
            <input type="text" id="txtPassword" name="txtPassword">
            <br/>

            <label for="txtAddress">Enter Address:</label>
            <input type="text" id="txtAddress" name="txtAddress">
            <br/>

            <label for="txtPhone">Enter Phone:</label>
            <input type="text" id="txtPhone" name="txtPhone">
            <br/>
            
            <label for="txtUser">Enter User:</label>
            <input type="text" id="txtUser" name="txtUser">
            <br/>
            
            <label for="txtAdmin">Enter Admin:</label>
            <input type="text" id="txtAdmin" name="txtAdmin">
            <br/>

            <div class="button-container">
                <button type="submit" class="submit-btn">Submit</button>
                <a href="account" class="back-btn">Back</a>
            </div>
        </form>
    </body>
</html>
