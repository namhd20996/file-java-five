<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/9/2023
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<form action="" method="post">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 offset-sm-3">
                <form action="<c:url value='/login'/>" method="post">
                    <div class="form-group m-2">
                        <label for="">Username</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <div class="form-group m-2">
                        <label for="">Password</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <div class="form-check m-2">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck1" name="remember">
                        <label class="form-check-label" for="defaultCheck1">
                            Remember
                        </label>
                    </div>
                    <button class="btn btn-info m-2" type="submit">Login</button>
                    <a  class="btn btn-info" href="<c:url value='/home-page'/>">Index</a>
                </form>
            </div>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
