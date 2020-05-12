<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/12/20
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/7/20
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Edit Incident"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class=""h-100>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid">
        <h1 class="text-center m-3 p-3">Treat Tracker Admin</h1>
        <jsp:include page="adminMenu.jsp" />

        <div>
            <h1>Page under construction</h1>
            <form action="#" method="post" class="needs-validation rounded-lg shadow-sm p-4 mb-4 bg-white" novalidate>
                <div class="form-group">
                    <label for="user">User:</label>
                    <select id="user" name="user" required>
                        <c:forEach var="user" items="${users}">
                            <c:choose>
                                <c:when test="${user.id == incident.user}">
                                    <option value="${user.user_name}" selected="selected">${user.first_name} ${user.last_name}</option>
                                </c:when>
                            </c:choose>
                            <c:otherwise>
                                <option value="${user.user_name}">${user.first_name} ${user.last_name}</option>
                            </c:otherwise>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="date">Incident Date:</label>
                    <input type="text" class="form-control" id="date" name="date" value="${incident.incident_date}" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description" value="${incident.description}" required>
                </div>
                <div class="form-group">
                    <label for="resolution">Resolution:</label>
                    <select id="resolution" name="resolution" required>
                        <c:forEach var="resolution" items="${resolutions}">
                            <c:choose>
                                <c:when test="${resolution.id == incident.resolution}">
                                    <option value="${resolution.id}" selected="selected">${resolution.id}</option>
                                </c:when>
                            </c:choose>
                            <c:otherwise>
                                <option value="${resolution.id}">${resolution.id}</option>
                            </c:otherwise>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-light">Submit</button>
                <button type="reset" class="btn btn-light">Reset</button>
                <a href="all-incidents" class="btn btn-light">Cancel</a>
            </form>
            <script>
                validateForm()
            </script>
        </div>
    </div>
</div>
</div>
</body>
</html>