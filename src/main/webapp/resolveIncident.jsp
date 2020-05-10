<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 5/9/20
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Resolve Incident"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class=""h-100>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid m-2">
        <h1 class="text-center m-2">Resolve Incident</h1>
        <h2 class="text-center m-2">Select a User</h2>
        <hr/>
        <div class="d-flex justify-content-center">
            <c:forEach var="user" items="${users}">
                <div class="card m-2" style="width:10em">
                    <img class="card-img-top" src="images/${user.user_name}.png" alt="Card image">
                    <div class="card-body">
                        <a href="incident-info?id=${user.id}" class="btn btn-light stretched-link">${user.first_name} ${user.last_name}</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <hr/>
        <h3 class="text-center m-2 p-2">${message}</h3>
        <div class="d-flex justify-content-center m-2 p-2">
            <c:if test="${not empty resolveForm}">
                <div class="rounded-lg shadow-sm p-4 mb-4 bg-white p-2 m-2">
                    <h4 class="text-center m-2">Incident Details</h4>
                    <div class="d-flex justify-content-center m-2">
                        <table class="m-2">
                            <tr>
                                <td class="p-2 m-2">Incident Date:</td>
                                <td class="p-2 m-2">${incidentToResolve.incident_date}</td>
                            </tr>
                            <tr>
                                <td class="p-2 m-2">Detail:</td>
                                <td class="p-2 m-2">${incidentToResolve.description}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <form action="resolve-incident?id=${param.id}" method="post" class="needs-validation rounded-lg shadow-sm p-4 mb-4 bg-white m-2 p-2" novalidate>
                    <div class="form-group">
                        <label for="description">Resolution Note:</label><br/>
                        <textarea id="description" name="description" rows="5" cols="80" required></textarea>
                    </div>
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-light m-2 p-2">Submit</button>
                        <button type="reset" class="btn btn-light m-2 p-2">Reset</button>
                        <a href="all-users?function=resolve" class="btn btn-light m-2 p-2">Cancel</a>
                    </div>
                </form>
                <script>validateForm()</script>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
