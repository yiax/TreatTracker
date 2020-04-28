<%--
  Created by IntelliJ IDEA.
  User: yiax
  Date: 4/21/20
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<html lang="en" class=""h-100>
<jsp:include page="head.jsp" />
<body class="h-100">
<div class="container">
    <jsp:include page="navbar.jsp" />

    <div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-10 col-md-8 col-lg-6">
                <form action="j_security_check" method="post">
                    <h1>Login Credential</h1>
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control username" id="username" placeholder="Username..." name="j_username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control password" id="password" placeholder="Password..." name="j_password">
                    </div>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
