<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 4/21/20
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "session" value = "Login"/>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class="h-100">
<div class="container">
    <jsp:include page="navbar.jsp" />

    <div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-10 col-md-8 col-lg-6">
                <h1 class="d-flex justify-content-center">Login</h1>
                <form action="j_security_check" method="post" class="needs-validation rounded-lg shadow-sm p-4 mb-4 bg-white" novalidate>
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control username" id="username" placeholder="Username..." name="j_username" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your Username.</div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control password" id="password" placeholder="Password..." name="j_password" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please enter your password.</div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="button">Submit</button>
                    </div>
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
