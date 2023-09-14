<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 4/29/2023
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="row">
            <h1 class="text-center">Form Bài 2</h1>
            <div class="col-sm-6 offset-sm-3">
                <form action="<c:url value='/bai-2/2022'/>" method="post">
                    <div class="form-group">
                    <label for="">Nhập Y</label>
                        <input value="2023" class="form-control" name="y"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
                <ul class="list-group">
                    <li class="list-group-item">${x}</li>
                    <li class="list-group-item">${y}</li>
                </ul>
                <a class="btn btn-info" href="<c:url value='/home-page'/>">Index</a>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
