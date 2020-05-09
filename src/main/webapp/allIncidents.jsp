<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/8/20
  Time: 2:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Admin | Edit Incidents"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class=""h-100>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid">
        <h1>Treat Tracker Admin</h1>
        <jsp:include page="adminMenu.jsp" />
        <div class="m-3">
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
            <div>

            </div>
            <table class="table table-responsive-lg table-hover">
                <thead class="thead-dark">
                <tr>
                    <th>User</th>
                    <th>Date</th>
                    <th>Description</th>
                    <th>Resolved</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <c:forEach var="incident" items="${incidents}">
                    <tr>
                        <td>${incident.user.first_name} ${incident.user.last_name}</td>
                        <td>${incident.incident_date}</td>
                        <td>${incident.description}</td>
                        <td>
                            <c:if test="${not empty incident.resolution}">Yes</c:if>
                            <c:if test="${empty incident.resolution}">No</c:if>
                        </td>
                        <td><a href="edit-incident?edit=update&id=${incident.id}"><img src="images/edit.png" alt="pencil"/></a></td>
                        <td><a href="edit-incident?edit=delete&id=${incident.id}"><img src="images/delete.png" alt="trash"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
