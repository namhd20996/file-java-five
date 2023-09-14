<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/13/2023
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>List Users</h2>
    <a href="<c:url value='/account/register'/>" class="btn btn-primary">Add
        Users</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Photo</th>
            <th>UserName</th>
            <th>Password</th>
            <th>FullName</th>
            <th>Email</th>
            <th>Activated</th>
            <th>Admin</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${accounts}">
        <tr>
            <td align="center"><img src="https://cdn1.iconfinder.com/data/icons/avatar-3/512/Manager-512.png" width="40"
                                    height="40"/></td>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${item.fullname}</td>
            <td>${item.email}</td>
            <td>${item.activated}</td>
            <td>${item.admin}</td>
            <td><a class="btn btn-primary btn-sm" href="<c:url value='/account/edit-account?username=${item.username}'/>">Edit</a>
                | <a class="btn btn-danger btn-sm" href="<c:url value='/account/delete-account?username=${item.username}'/>">Del</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


