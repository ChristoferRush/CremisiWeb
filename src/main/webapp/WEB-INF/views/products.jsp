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
    <p>List of our available products:</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Rating</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${issues}" var="product">
                <tr>
                    <td><b>${product.name}</b></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.rating}</td>
                    <td><button type="button" class="btn" formaction="/cart/add/${product.id}">Add to cart</button></td>
                </tr>
            </c:forEach>
            <c:forEach items="${volumes}" var="product">
                <tr>
                    <td><b>${product.name}</b></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.rating}</td>
                    <td><button type="button" class="btn" formaction="/cart/add/${product.id}">Add to cart</button></td>
                    <td><a href="<c:url value='/cart/add/${product.id}'/>">Add to cart</a></td>
                </tr>
            </c:forEach>
            <c:forEach items="${companionBooks}" var="product">
                <tr>
                    <td><b>${product.name}</b></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.rating}</td>
                    <td><button type="button" class="btn" formaction="/cart/add/${product.id}">Add to cart</button></td>
                </tr>
            </c:forEach>
            <c:forEach items="${artBooks}" var="product">
                <tr>
                    <td><b>${product.name}</b></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.rating}</td>
                    <td><button type="button" class="btn" formaction="/cart/add/${product.id}">Add to cart</button></td>
                </tr>
            </c:forEach>
            <c:forEach items="${packs}" var="product">
                <tr>
                    <td><b>${product.name}</b></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.rating}</td>
                    <td><button type="button" class="btn" formaction="/cart/add/${product.id}">Add to cart</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
