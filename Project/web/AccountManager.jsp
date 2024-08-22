<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 80%;
                margin: 20px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            }

            h2 {
                color: #333;
                margin-bottom: 20px;
                border-bottom: 2px solid #333;
                padding-bottom: 10px;
                text-transform: uppercase;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 12px;
                text-align: left;
                transition: background-color 0.3s;
            }

            th {
                background-color: #f2f2f2;
                text-transform: uppercase;
                font-size: 14px;
                color: #555;
            }

            td {
                font-size: 14px;
                color: #333;
            }

            img {
                max-width: 80px;
                max-height: 80px;
                border-radius: 5px;
            }

            .action-links {
                display: flex;
            }

            .action-links a {
                color: #fff;
                text-decoration: none;
                padding: 8px 12px;
                border-radius: 5px;
                transition: background-color 0.3s;
            }

            .action-links a:hover {
                background-color: #007bff;
            }

            .update-btn {
                background-color: #28a745;
            }

            .delete-btn {
                background-color: #dc3545;
                margin-left: 5px;
            }
        </style>
    </head>

    <body>
<!--        <form action="searchbyprice" method="post">
            <div class="input-group">
                <input name="min" type="text" class="form-control" placeholder="Search this blog">
                <input name="max" type="text" class="form-control" placeholder="Search this blog">
                <div class="input-group-append">
                    <button class="btn btn-secondary" type="submit" style="background-color: #f26522; border-color:#f26522 ">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
        </form>-->

        <div class="container">
            
            <h2><a href="addaccount">Add Account</a></h2>

            <table>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>User</th>
                    <th>Admin</th>
                </tr>
                <c:forEach items="${requestScope.listAccount}" var="account">
                    <tr>
                        <td>${account.user_id}</td>
                        <td>${account.username}</td>
                        <td>${account.address}</td>
                        <td>${account.phone}</td>
                        <td>${account.isUser}</td>
                        <td>${account.isAdmin}</td>
                        <td class="action-links">
                            <a href="updateaccount?userID=${account.user_id}" class="update-btn">Update</a>
                            <a href="deleteaccount?userID=${account.user_id}" class="delete-btn">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>

    </body>
</html>
