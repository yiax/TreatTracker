<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/7/20
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Admin | Edit User"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class=""h-100>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid">
        <h1>Treat Tracker Admin</h1>
        <jsp:include page="adminMenu.jsp" />
        <div class="m-2">
        <c:choose>
            <c:when test="${not empty param.delete && not empty param.first && not empty param.last}">
                <p class="text-center text-primary">${param.first} ${param.last} was successfully deleted.</p>
            </c:when>
            <c:when test="${empty param.delete && not empty param.first && not empty param.last}">
                <p class="text-center text-primary">${param.first} ${param.last}'s profile was successfully updated.</p>
            </c:when>
        </c:choose>
        </div>

        <div class="d-flex justify-content-center flex-wrap">
            <c:forEach var="user" items="${users}">
                <div class="card w-25 m-2">
                    <div class="card-body">
                        <h4 class="card-title">${user.first_name} ${user.last_name}</h4>
                        <p class="card-text">Username: ${user.user_name}</p>
                        <p class="card-text">Email: ${user.email}</p>
                        <c:forEach var="role" items="${roles}">
                            <c:if test="${user.id == role.user.id}">
                                <c:set var="userRole" value="${role.role}" scope="application"></c:set>
                                <p class="card-text">Role: ${userRole}</p>
                            </c:if>
                        </c:forEach>

                        <a href="user-info?id=${user.id}&role=${userRole}" class="stretched-link"></a>
                    </div>
                </div>
            </c:forEach>

            <c:if test="${success == 1}">
                <div>
                    <form action="update-user?id=${param.id}" method="post" class="needs-validation rounded-lg shadow-sm p-4 mb-4 bg-white" novalidate>
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" value="${firstName}" required>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" value="${lastName}" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="text" class="form-control" id="email" name="email" value="${email}" required>
                        </div>
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" name="username" value="${username}" required>
                        </div>
                        <div class="form-group">
                            <label for="role">Role:</label>
                            <select id="role" name="role" required>
                                <c:choose>
                                    <c:when test="${param.role == 'basic'}">
                                        <option value="basic" selected="selected">basic</option>
                                        <option value="admin">admin</option>
                                    </c:when>
                                    <c:when test="${param.role == 'admin'}">
                                        <option value="basic">basic</option>
                                        <option value="admin" selected="selected">admin</option>
                                    </c:when>
                                </c:choose>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" id="delete" name="delete" value="delete">
                            <label for="delete">Delete User</label>
                        </div>

                        <button type="submit" class="btn btn-light">Submit</button>
                        <button type="reset" class="btn btn-light">Reset</button>
                        <a href="all-users" class="btn btn-light">Cancel</a>
                    </form>
                    <script>
                        validateForm()
                    </script>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>