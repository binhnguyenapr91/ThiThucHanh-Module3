<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 5/26/20
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View All</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="boostrap/css/bootstrap.css">
    <link rel="stylesheet" href="boostrap/css/mainStyle.css">
</head>
<body>

<form action="/productServlet" method="post">
    <table class="table table-hover">
        <tr>
            <td colspan="9"><a href="/productServlet?action=add">Create New Product</a></td>
        </tr>
        <tr>
            <td>
                ProductID
            </td>
            <td>
                ProductName
            </td>
            <td>
                ProductPrice
            </td>
            <td>
                ProductQuantity
            </td>
            <td>
                ProductColor
            </td>
            <td>
                ProductDesctiption
            </td>
            <td>
                ProductCategoryID
            </td>
            <td colspan="2">Functions</td>
        </tr>
        <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.getProductId()}</td>
            <td>${product.getProductName()}</td>
            <td>${product.getProductPrice()}</td>
            <td>${product.getProductQuantity()}</td>
            <td>${product.getProductColor()}</td>
            <td>${product.getProductDescription()}</td>
            <td>${product.getProductCategoryId()}</td>
            <td><a href="/productServlet?action=update&productId=${product.getProductId()}">Update</a></td>
            <td><a href="/productServlet?action=delete&productId=${product.getProductId()}">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
