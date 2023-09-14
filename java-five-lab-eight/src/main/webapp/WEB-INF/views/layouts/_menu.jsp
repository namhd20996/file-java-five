<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="#"><s:message code="lo.mn.home"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"><s:message code="lo.mn.about"/> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><s:message code="lo.mn.contact"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><s:message code="lo.mn.feedback"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><s:message code="lo.mn.question"/></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="?lang=en" class="mr-4">English</a></li>
            <li><a href="?lang=vi">Tiếng Việt</a></li>
        </ul>
    </div>
</nav>

<script>
    $(document).ready(function(){
        $("a[href*=lang]").on("click", function(){
            var param = $(this).attr("href");
            $.ajax({
                url: "/home/index" + param,
                success: function(){
                    location.reload();
                }
            });
            return false;
        })
    })
</script>

