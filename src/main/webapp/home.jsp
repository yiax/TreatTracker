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
                                <div class="col-md-12 bg-primary">My Treat Incidents</div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 bg-info">
                                    <h2>Users</h2>
                                    <table id="users" class="display" cellspacing="0" width="100%">
                                        <thead>
                                        <th>Name</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="trail" items="${trails}">
                                            <tr>
                                                <td>${user.first_name} + ' ' + ${user.last_name}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-6 bg-danger">More Stuff</div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 bg-white">Things</div>
                                <div class="col-md-6 bg-dark">More Things</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 bg-warning">
                    <h2>Recent Activities</h2>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
