<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cremisi Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Cremisi Online Comic Store</h2>
    <p class="col-lg-8">Your cart:</p>
    <div class="col-lg-4">
        <p><a href="<c:url value='/product/list'/>">Back to products</a></p>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Amount</th>
            <th>Product</th>
            <th>Add more</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cartItems}" var="item">
            <tr>
                <td>${item.amount}</td>
                <td>${item.product}</td>
                <td><a href="<c:url value='/cart/increase/${item.product.id}'/>">Increase amount</a></td>
                <td><a href="<c:url value='/cart/decrease/${item.product.id}'/>">Decrease amount</a></td>
                <td><a href="<c:url value='/cart/remove/${item.product.id}'/>">Remove from cart</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p class="offset-8 col-lg-4"><a href="<c:url value='/order'/>">Proceed to order</a></p>
</div>

</body>
</html>
