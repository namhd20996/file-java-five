<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/25/2023
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span class="h1">${uri}</span>
<div class="list-group">
    <a href="#" class="list-group-item list-group-item-action list-group-item-primary">Category</a>
    </a>
    <c:forEach var="item" items="${categories}">
        <a href="#" class="list-group-item list-group-item-action list-group-item-light">${item}</a>
    </c:forEach>
</div>