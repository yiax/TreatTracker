<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 4/15/20
  Time: 11:27 PM
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
            <h2 class="d-flex justify-content-center">Your Username or Password is incorrect.</h2>
            <h3 class="d-flex justify-content-center">Please try again.</h3>
            <div class="d-flex justify-content-center">
                <a href="user-home" class="btn btn-light" role="button">Login</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
