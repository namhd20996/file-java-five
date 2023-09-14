<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/19/2023
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row offset-sm-3">
    <div class="col-sm-8">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <th scope="row">${item.id}</th>
                    <td>${item.name}</td>
                    <td><a href="<c:url value="/bai-2/edit?id=${item.id}"/>" class="btn btn-info">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
