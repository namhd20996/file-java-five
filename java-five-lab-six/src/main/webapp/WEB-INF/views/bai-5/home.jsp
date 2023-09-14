<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/20/2023
  Time: 7:00 PM
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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="<c:url value="/template/paging/jquery.twbsPagination.js" />"></script>
</head>

<body>
<div class="container">
    <h1 class="text-center">Search & Page</h1>
    <form action="<c:url value="/bai-5" />" method="get">
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label for="keyword">Keyword</label>
                    <input id="keyword" class="form-control" value="${param.keyword}" placeholder="Keyword ?"
                           type="text" name="keyword">
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
    <form action="<c:url value="/bai-5"/> " id="formSubmit" method="get">
        <div class="col d-flex justify-content-center">
            <ul class="pagination" id="pagination"></ul>
            <input type="hidden" value="" id="page" name="page"/>
            <input type="hidden" value="" id="limit" name="limit"/>
        </div>
    </form>
    <ul>
    <li>Số thực thể hiện tại: ${model.page}</li>
    <li>Trang số: ${model.page}</li>
    <li>Kích thước trang: ${model.limit}</li>
    <li>Tổng số thực thể: ${model.totalItem}</li>
    <li>Tổng số trang: ${model.totalPage}</li>
    </ul>
</div>
<script type="text/javascript">
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 4,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#limit').val(2);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        })
    });
</script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
