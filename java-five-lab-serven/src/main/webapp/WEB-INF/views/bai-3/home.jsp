<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duy Nam
  Date: 5/24/2023
  Time: 7:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-8 offset-sm-2 mt-5">
            <h1>Send Mail</h1>
            <form action="<c:url value="/bai-3"/> " method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="from">From</label>
                            <input id="from" type="text" class="form-control" name="from">
                        </div>
                        <div class="form-group">
                            <label for="cc">Cc</label>
                            <input id="cc" type="text" class="form-control" name="cc">
                        </div>
                        <div class="form-group">
                            <label for="subject">Subject</label>
                            <input id="subject" type="text" class="form-control" name="subject">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="to">To</label>
                            <input id="to" type="text" class="form-control" name="to">
                        </div>
                        <div class="form-group">
                            <label for="bcc">Bcc</label>
                            <input id="bcc" type="text" class="form-control" name="bcc">
                        </div>
                        <div class="form-group">
                            <label for="files">From</label>
                            <input id="files" type="file" class="form-control" name="attachment">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="body">Body</label>
                    <textarea class="form-control" name="body" id="body" cols="20" rows="5"></textarea>
                </div>
               <div class="form-group mt-2">
                   <button class="btn btn-info form-control" type="submit">Send mail?</button>
                   <a class="btn btn-info form-control mt-2" href="<c:url value="/home-page"/> ">Index</a>
               </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
