<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/19/2023
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="" method="post" modelAttribute="item">
    <div class="row offset-sm-3">
        <div class="col-sm-4">
            <div class="form-group">
                <label for="id">Id</label>
                <form:input id="id" cssClass="form-control" type="text" path="id" placeholder="Category Id?"/>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input id="name" cssClass="form-control" type="text" path="name" placeholder="Category Name?"/>
            </div>
        </div>
    </div>
    <div class="row mb-2">
        <div class="col-sm-6 offset-sm-3">
            <hr>
        </div>
    </div>
    <div class="row offset-sm-3 mb-3">
        <div class="col-sm-6">
            <button formaction="<c:url value="/bai-2/create"/> " class="btn btn-info">Create</button>
            <button ${item.id!=null?'':'disabled'}  formaction="<c:url value="/bai-2/update" />" class="btn btn-warning">Update</button>
            <a href="<c:url value="/bai-2/delete?id=${item.id}"/>" class="btn btn-danger">Delete</a>
            <a href="<c:url value="/bai-2" />" class="btn btn-success">Reset</a>
            <a href="<c:url value="/home-page" />" class="btn btn-success">Index</a>
        </div>
    </div>
</form:form>
