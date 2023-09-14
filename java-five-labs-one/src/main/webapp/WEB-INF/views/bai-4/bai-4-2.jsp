<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 4/28/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="<c:url value='/bai-4'/>" method="post">
        <div class="form-group">
            <label for="">Uername</label>
            <input type="text" name="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Password</label>
            <input type="text" name="password" class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Send</button>
    </form>
    <c:if test="${success!=null}">
        ${success} <a class="btn btn-success" href="<c:url value='/bai-4-cookie'/>">Read Cookie</a>
    </c:if>
    <h3>Cookie</h3> <br>
    <c:forEach var="item" items="${map}">
        Username: ${item.key}  Password: ${item.value}<br>
    </c:forEach>
    <button formmethod="get"></button>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</html>
