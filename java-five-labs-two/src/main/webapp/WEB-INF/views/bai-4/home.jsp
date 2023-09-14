<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 4/29/2023
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 offset-sm-3 mt-4">
            <form action="<c:url value='/product/save'/>" method="post">
                <div class="form-group">
                    <label for="">Name</label>
                    <input type="text" class="form-control" name="name"/>
                </div>
                <div class="form-group">
                    <label for="">Price</label>
                    <input type="number" class="form-control" name="price"/>
                </div>
                <button type="submit" class="btn btn-info">Send</button>
                <a class="btn btn-info" href="<c:url value='/home-page'/>">Index</a>
            </form>
            <ul class="list-group">
                <li class="list-group-item">Product One</li>
                <li class="list-group-item list-group-item-primary">${model.name}</li>
                <li class="list-group-item list-group-item-secondary">${model.price}</li>
            </ul>
            <ul class="list-group">
                <li class="list-group-item">Product Two</li>
                <li class="list-group-item list-group-item-primary">${product.name}</li>
                <li class="list-group-item list-group-item-secondary">${product.price}</li>
            </ul>
            <ul class="list-group">
                <li class="list-group-item">Product Three</li>
                <c:forEach var="item" items="${items}">
                    <li class="list-group-item list-group-item-primary">${item.name}</li>
                    <li class="list-group-item list-group-item-secondary">${item.price}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>