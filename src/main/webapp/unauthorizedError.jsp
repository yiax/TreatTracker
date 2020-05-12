<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/12/20
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Login Fail"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="contentType.jsp" />
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center ">
        <div class="rounded-lg shadow-sm p-4 mb-4 bg-white">
            <h1>Error 403: Forbidden</h1>
            <h2 class="d-flex justify-content-center">Opps! You are unauthorized to access this page.</h2>
            <div class="d-flex justify-content-center">
                <a href="javascript:history.back()" class="btn btn-light" role="button">Return</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
