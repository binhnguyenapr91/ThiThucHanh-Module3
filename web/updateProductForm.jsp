<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 5/26/20
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Product</title>
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
<form method="post">
    <table class="table table-hover">
        <tr>
            <td colspan="6">Update Product</td>
        </tr>
        <tr>
            <td>
                ProductName
            </td>
            <td>
                ProductPrice
            </td>
            <td>
                ProductQuantity
            </td>
            <td>ProductColor</td>
            <td>
                ProductDesctiption
            </td>
            <td>
                ProductCategoryID
            </td>
        </tr>
        <tr>
            <td><input type="text" name="productName" size="20" value="${requestScope["product"].getProductName()}"></td>
            <td><input type="text" name="productPrice" size="20" value="${requestScope["product"].getProductPrice()}"></td>
            <td><input type="text" name="productQuantity" size="20" value="${requestScope["product"].getProductQuantity()}"></td>
            <td><input type="text" name="productColor" size="20" value="${requestScope["product"].getProductColor()}"></td>
            <td><input type="text" name="productDescription" size="20" value="${requestScope["product"].getProductDescription()}"></td>
            <td><input type="text" name="productCategoryId" size="20" value="${requestScope["product"].getProductCategoryName()}"></td>
        </tr>
        <tr>
            <td colspan="6"><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>
</body>
</html>
