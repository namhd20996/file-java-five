<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/20/2023
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h1 class="text-center">Search by price</h1>
    <form action="<c:url value="/bai-4" />" method="get">
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label for="min">Min</label>
                    <input id="min" class="form-control" value="${param.min}" placeholder="Min Price" type="number" name="min">
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <label for="max">Max</label>
                    <input id="max" class="form-control" value="${param.max}" placeholder="Max Price" type="number" name="max">
                </div>
            </div>
            <div class="col-sm-2" style="margin-top: 32px;">
                <button type="submit" class="btn btn-info">Search</button>
                <a class="btn btn-info" href="<c:url value="/home-page"/> ">Index</a>
            </div>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <th scope="row">${item.id}</th>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>@${item.createDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
