<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/template/css/bootstrap.min.css'/> ">
</head>
<body>
<div class="container">
    <div class="row">
        <form:form action="bai-5" method="post" modelAttribute="sv">
            <div class="col-sm-6 offset-sm-3 mt-5">
                <div class="orm-group">
                    <label for="name">Name</label>
                    <form:input id="name" path="name" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <form:input id="email" path="email" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="marks">Marks</label>
                    <form:input id="marks" path="marks" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>
                    <form:radiobuttons id="gender" path="gender" items="${listGender}"/>
                </div>
                <div class="form-group">
                    <label for="faculty">Faculties</label>
                    <form:checkboxes id="faculty" path="faculty" items="${listFaculties}"/>
                </div>
               <form:select path="hobbies" cssClass="form-select" aria-label="Default select example">
                   <form:option value="" label="Faculty"/>
                   <form:options items="${listHobbie}"/>
               </form:select>
                <div class="form-group">
                    <label>Message</label>
                    ${message}
                    <%-- path="*" thông báo tất cả các lỗi
                        element="li" thông báo lỗi bằng thẻ nào?
                        delimiter=";" phần phân cách các lỗi
                    --%>
                    <form:errors path="*" element="li" delimiter=";"/>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-info mt-4">Send</button>
                    <a class="btn btn-warning mt-4" href="<c:url value="/home-page"/>">Home</a>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
