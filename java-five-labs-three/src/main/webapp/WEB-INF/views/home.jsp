<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 4/29/2023
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/template/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 offset-sm-4 mt-5">
                <a class="btn btn-warning" href="<c:url value="/home-page"/>">Home</a>
                <a class="btn btn-info" href="<c:url value="/bai-1"/>">Bài 1</a>
                <a class="btn btn-info" href="<c:url value="/bai-2"/>">Bài 2</a>
                <a class="btn btn-info" href="<c:url value="/bai-5"/>">Bài 5</a>
            </div>
        </div>
    </div>
</body>
</html>
