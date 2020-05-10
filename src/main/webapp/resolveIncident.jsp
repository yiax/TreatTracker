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
    <h2 class="text-center">Select a user to resolve</h2>
    <hr/>
    <div class="d-flex justify-content-center">
        <c:forEach var="user" items="${users}">
            <div class="card m-2" style="width:10em">
                <img class="card-img-top" src="images/avatar1.png" alt="Card image">
                <div class="card-body">
                    <a href="incident-info?id=${user.id}" class="btn btn-light stretched-link">${user.first_name} ${user.last_name}</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <hr/>
    <div>
        <h3 class="text-center">${message}</h3>
        <c:if test="${not empty resolveForm}">
            <div>
            <h4>Incident Detail</h4>
            <p>Incident Date: ${incidentToResolve.incident_date}</p>
            <p>Detail: ${incidentToResolve.description}</p>
            </div>
            <form action="resolve-incident?id=${param.id}" method="post" class="needs-validation rounded-lg shadow-sm p-4 mb-4 bg-white" novalidate>
                <div class="form-group">
                    <label for="description">Resolution Note:</label><br/>
                    <textarea id="description" name="description" rows="5" cols="80" required></textarea>
                </div>

                <button type="submit" class="btn btn-light">Submit</button>
                <button type="reset" class="btn btn-light">Reset</button>
                <a href="all-users?function=resolve" class="btn btn-light">Cancel</a>
            </form>
        </c:if>
    </div>
</div>

</body>
</html>
