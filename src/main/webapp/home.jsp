<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 2/27/20
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="contentType.jsp" />
<html>
<jsp:include page="head.jsp" />
<body>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid">
        <div class="container-fluid">
            <div class="row h-100">
                <div class="col-md-8 bg-success">
                    <div class="container-fluid">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-12 bg-primary">
                                    <h2>My Treat Incidents</h2>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 bg-info">
                                    <h2>Treat Tracker Individuals</h2>
                                    <div class="card-columns">
                                    <c:forEach var="user" items="${users}">
                                        <div class="card">
                                            <img class="card-img-top" src="img_avatar1.png" alt="Card image">
                                            <div class="card-body">
                                                <p class="card-title">${user.first_name} ${user.last_name}</p>
                                                <a href="#" class="btn btn-primary">See Profile</a>
                                                <a href="#" class="btn btn-primary">Resolve Incident</a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 bg-white">
                                    <h2>More Things</h2>
                                </div>
                                <div class="col-md-6 bg-dark">
                                    <h2>Additional Stuff</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 bg-warning">
                    <h2>Recent Activities</h2>
                    <c:forEach var="incident" items="${incidents}">
                        <tr>
                            <td>${incident.description}</td>
                        </tr>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
