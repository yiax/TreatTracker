<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 2/27/20
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "My Dashboard"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class=""h-100>
<div class="container">
    <jsp:include page="userNavbar.jsp" />
    <div class="container-fluid m-3">
        <div class="container-fluid">
            <div class="row h-100">
                <div class="col-md-8">
                    <div class="container-fluid">
                        <div class="container-fluid">
                            <div class="row border mb-3 rounded-lg">
                                <div class="col-md-12">
                                    <div class="d-flex justify-content-center m-2 p-2">
                                        <div class="card m-2 p-2 border-0" style="width:250px">
                                            <h1 class="card-title">${loginUser.first_name} ${loginUser.last_name}</h1>
                                            <img class="card-img-top" src="images/${loginUser.user_name}.png" alt="image of ${loginUser.first_name}" />
                                            <div class="card-body">
                                                <a href="#" class="btn btn-primary">See Profile</a>
                                            </div>
                                        </div>
                                        <div class="m-2 p-2">
                                            <p>TO DO: Display un-resolve incidents</p>
                                            <p>TO DO: Display how fast/slow it takes for target user to resolve incident</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row border mt-3 rounded-lg">
                                <div class="col-md-12">
                                    <h2>Treat Tracker Record Holders</h2>
                                    <div class="card-columns d-flex justify-content-center flex-wrap">
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Most Incidents</h4>
                                            <img class="card-img-top" src="images/fodling.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p>Number of active incidents</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Least Incidents</h4>
                                            <img class="card-img-top" src="images/kyates.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p># of active incidents</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Most Unresolved</h4>
                                            <img class="card-img-top" src="images/aduggan.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p># of unresolved incident</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Most Resolved</h4>
                                            <img class="card-img-top" src="images/jbate.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p># of incident resolved</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Quickest to Resolve</h4>
                                            <img class="card-img-top" src="images/awarren.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p>Fastest avg time</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Slowest to Resolve</h4>
                                            <img class="card-img-top" src="images/jbate.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p>Slowest avg time</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Fastest Record</h4>
                                            <img class="card-img-top" src="images/lmcmanus.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p>Fastest time</p>
                                            </div>
                                        </div>
                                        <div class="card m-3 border-0" style="width:130px">
                                            <h4 class="card-title">Slowest Record</h4>
                                            <img class="card-img-top" src="images/fodling.png" alt="Card image">
                                            <div class="card-body">
                                                <p>FirstName LastName</p>
                                                <p>Slowest time</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 p-2 border rounded-lg">
                    <h1>Recent Activities</h1>
                    <div class="mt-2 mb-2 p-2">
                        <h3>Incidents</h3>
                        <c:forEach var="incident" items="${incidents}">
                            <p>${incident.user.first_name} ${incident.user.last_name} had an incident on
                                    ${incident.incident_date} and said '${incident.description}'.</p>
                        </c:forEach>
                    </div>
                    <div class="mt-2 mt-2 p-2">
                        <h3>Resolutions</h3>
                        <c:forEach var="resolution" items="${resolutions}">
                            <p>${resolution.user.first_name} ${resolution.user.last_name} resolved his/her incident from
                                    ${resolution.incident_date} on ${resolution.resolution.resolution_date}.</p>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
