<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 4/15/20
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Admin"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class=""h-100>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid">
        <h1 class="text-center m-3 p-3">Treat Tracker Admin</h1>
        <jsp:include page="adminMenu.jsp" />
    </div>
</body>
</html>
