<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/10/20
  Time: 4:32 PM
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
        <h1 class="text-center m-3 p-3">Treat Tracker Admin</h1>
        <jsp:include page="adminMenu.jsp" />
        <div class="m-3">
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
            <div>

            </div>
            <table class="table table-responsive-lg table-hover">
                <thread class="thead-dark">
                    <tr >
                        <th>Sender</th>
                        <th>Date</th>
                        <th>Subject</th>
                        <th>Body</th>
                        <th>Add Incident</th>
                    </tr>
                </thread>
                <c:forEach var="email" items="${emails}">
                    <tr class="table table-responsive-lg table-hover">
                        <td>${email.from}</td>
                        <td>${email.date}</td>
                        <td>${email.subject}</td>
                        <td>${email.body}</td>
                        <td><a href="add-incident?id=${email.id}&email=${email.from}&date=${email.date}&subject=${email.subject}&body=${email.body}"><img src="images/add.png" alt="add symbol" style="width: 1em"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
