<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>JSP Page</title>
</head>
<body>
<div class="container" style="margin-top: 10px;">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h2>Register Account</h2>
            <form:form action="/account/register" modelAttribute="account" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>UserName</label>
                    <form:input type="text" class="form-control" path="username" placeholder="Enter UserName"/>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <form:input type="password" class="form-control" path="password" placeholder="Enter password"/>
                </div>
                <div class="form-group">
                    <label>FullName</label>
                    <form:input type="text" class="form-control" path="fullname" placeholder="Enter fullname"/>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <form:input type="text" class="form-control" path="email" placeholder="Enter email"/>
                </div>
                <div class="form-group">
                    <label>Photo</label>
                    <input type="file" class="form-control" name="image" placeholder="Enter photo"/>
                </div>
                <div class="form-group">
                    <label>Status</label>
                    <div class="radio"><!--value = 1 => Nam| 0 =>Nu -->
                        <label class="checkbox-inline">
                            <form:checkbox path="activated"/>Activated</label>
                        <label class="checkbox-inline">
                            <form:checkbox path="admin"/>Admin</label>
                    </div>
                </div>
                <form:button type="submit" class="btn btn-info">Submit</form:button>
                <form:button type="reset" class="btn btn-info">Cancel</form:button>
                <a href="<c:url value='/account/views'/> " class="btn btn-info">Display Account</a>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
